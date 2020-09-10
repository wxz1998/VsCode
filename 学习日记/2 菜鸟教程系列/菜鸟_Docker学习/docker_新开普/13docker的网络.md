# Docker的网络

## 前言

当你开始大规模使用Docker时，你会发现需要了解很多关于网络的知识。Docker作为目前最火的轻量级容器技术，有很多令人称道的功能，如Docker的镜像管理。然而，Docker同样有着很多不完善的地方，网络方面就是Docker比较薄弱的部分。因此，我们有必要深入了解Docker的网络知识，以满足更高的网络需求。

## Docker默认的三种网络模式

Docker 安装时会自动在 host 上创建三个网络，我们可用 docker network ls 命令查看：

```shell
[root@master-14920944d4474ae484ac1013cd336ddb ~]# docker network ls
NETWORK ID          NAME                DRIVER              SCOPE
81b62307ceb8        bridge              bridge              local
d2eea76c6e21        host                host                local
d99444328b2c        none                null                local
```

1. none网络
    * 故名思议，none网络就是什么都没有的网络。
    * 挂在这个网络下的容器除了lo，没有其他任何网卡。
    * 容器创建时，可以通过--network=none指定使用none网络。
    * 一些对安全性要求高并且不需要联网的应用可以使用none网络。
2. host网络
    * 连接到host网络的容器共享Docker宿主机的网络栈，容器的网络配置与宿主机完全一样，相当于Vmware中的桥接模式。
    * 可以通过--network=host指定使用host网络。
    * 直接使用Docker的host网络最大的好处就是性能，如果容器对网络传输效率有较高要求，则可以选择host网络。
    * 当然不便之处就是牺牲一些灵活性，比如要考虑端口冲突问题，Docker宿主机上已经使用的端口就不能再用了。
3. bridge网络
    * Docker安装时会创建一个命名为docker0的linux bridge。
    * bridge网络是Docker默认的网络设置，如果不指定--network，创建的容器默认都会挂到docker0上。
    * 相当于Vmware中的Nat模式，容器使用独立network Namespace。
    * 可以通过docker network inspect bridge命令查看bridge网络的配置信息:

```shell
[root@master-14920944d4474ae484ac1013cd336ddb ~]# docker network inspect bridge
[
    {
        "Name": "bridge",
        "Id": "8c897b071ea79f950cc86822d317d4a0f5e372829cccbe093e3f2ecabe180c83",
        "Created": "2019-04-01T09:31:19.277833485Z",
        "Scope": "local",
        "Driver": "bridge",
        "EnableIPv6": false,
        "IPAM": {
            "Driver": "default",
            "Options": null,
            "Config": [
                {
                    "Subnet": "172.17.0.0/16",
                    "Gateway": "172.17.0.1"
                }
            ]
        },
        "Internal": false,
        "Attachable": false,
        "Ingress": false,
        "ConfigFrom": {
            "Network": ""
        },
        "ConfigOnly": false,
        "Containers": {},
        "Options": {
            "com.docker.network.bridge.default_bridge": "true",
            "com.docker.network.bridge.enable_icc": "true",
            "com.docker.network.bridge.enable_ip_masquerade": "true",
            "com.docker.network.bridge.host_binding_ipv4": "0.0.0.0",
            "com.docker.network.bridge.name": "docker0",
            "com.docker.network.driver.mtu": "1500"
        },
        "Labels": {}
    }
]
```

## 自定义网络user-defined

Docker提供三种自定义网络网络驱动：bridge, overlay 和 macvlan

```shell
docker network create --driver bridge new-bridge
docker network create --driver bridge --subnet 192.168.0.0/24 --gateway 192.168.0.1 new-bridge

docker network inspect new-bridge
```

## 容器之间的连通性

1.两个容器都使用默认的bridge网络，直接可以使用IP地址PING通

```shell
## 1.启动两个容器
docker run -it --name centos1 centos
docker run -it --name centos2 centos

## 2.查看连个容器分别分配的IP地址是多少
docker network inspect bridge

## 3.两个容器之间使用IP互PING是可以通的
```

2.两个容器使用不同的bridge网络

```shell
## 1.创建两个bridge网络
docker network create --driver bridge new-bridge1
docker network create --driver bridge new-bridge2

## 2.运行两个容器，分别指定两个不同的bridge网络
docker run -it --rm --network new-bridge1 --name centos3 centos
docker run -it --rm --network new-bridge2 --name centos4 centos

## 3.分别查看两个容器的IP地址，经过测试两个IP地址之间是不能互通的
centos1 172.19.0.2
centos2 172.20.0.2

## 4.实现互通
## 为CentOS1主机添加new-bridge2网卡，可实现两个主机间互通
docker network connect new-bridge2 centos1
## 或为CentOS2主机添加new-bridge1网卡，也可实现两个主机间互通
docker network connect new-bridge1 centos2
```

## 容器间通信的三种方式

1.IP 通信:  
两个容器必须要有属于同一个网络的网卡就可以使用IP互相连接

2.Docker DNS Server：  
通过IP访问容器虽然满足了通信的需求，但还是不够灵活。因为我们在部署应用之前可能无法确定IP，部署之后再指定要访问的IP会比较麻烦。对于这个问题，可以通过docker自带的 DNS 服务解决。  
使用 docker DNS 需要满足的3个条件：

1. 只能在user-defined网络中使用。也就是说，默认的bridge网络是无法使用DNS的
2. 两个容器必须在同一个网络中
3. 必须通过--name指定容器名字

```shell
## 1.创建一个user-defined网络
docker network create --driver bridge new-net

## 2.启动两个容器
docker run -it -d --network new-net --name centos5 centos
docker run -it -d --network new-net --name centos6 centos

## 3.查看两个容器IP地址
docker network inspect new-net

centos5     172.21.0.2
centos6     172.21.0.3

## 4.测试互通性（以下都是可以PING通的）
## 在centos5容器内执行：
ping centos6
ping 172.21.0.3

## 在centos6容器内执行：
ping centos5
ping 172.21.0.2
```

3.joined容器
joined 容器是另一种实现容器间通信的方式。
joined 容器非常特别，它可以使两个或多个容器共享一个网络栈，共享网卡和配置信息，joined容器之间可以通过127.0.0.1直接通信。

```shell
## 1.先创建一个容器
docker run -it -d --name centos7 centos

## 2.创建第二个容器，并指定jointed容器为centos1
docker run -it -d --name centos8 --network container:centos7 centos

## 3.登录两个容器分别查看网络信息
yum install -y net-tools
ifconfig

##发现两个容器的网卡MAC地址和IP地址完全一样，它们共享了相同的网络栈。他们之间可以直接用127.0.0.1访问互相的服务。
```

## 网络常用命令

1.docker network 命令

序号 | 命令 | 说明
---|---|---
1 | docker network connect    | 将一个容器连接到一个网络
2 | docker network create     | 创建一个网络
3 | docker network disconnect | 将一个容器断开与一个网络的连接
4 | docker network inspect    | 显示一个或多个网络的详细信息
5 | docker network ls         | docker中所有网络的列表
6 | docker network prune      | 删除所有未使用的网络
7 | docker network rm         | 删除一个或多个网络

2.docker network create \[选项] 网络名称

序号 | 选项 | 说明
---|---|---
1 | -d, --driver | 设置网络的驱动，默认“bridge”
2 | --gateway | 主子网的IPv4或IPv6网关，格式：172.17.0.1
3 | --subnet | 指定子网，格式：172.17.0.0/16
4 | --ip-range | 设置子网IP分配区间
5 | --config-from | 从目前已经存在的某个网络复制配置
6 | --internal | 限制对网络的外部访问
7 | --ipam-driver | IP地址管理驱动程序（默认为“default”）
8 | --ipv6 | 允许IPV6网络
9 | --label | 为网络设置标签

2.docker network connect \[选项] 网络名称 容器名或ID

序号 | 选项 | 说明
---|---|---
1 | --alias | 为容器添加一个网络域别名
2 | --ip | 指定容器网络的IPv4地址，格式：172.17.0.5
3 | --ip6 | 指定容器网络的IPv6地址，，格式：2001:db8::33
4 | --link | 添加链接到另一个容器
5 | --link-local-ip | 为容器添加链接本地地址

3.docker network disconnect \[选项] 网络名称 容器名或ID

序号 | 选项 | 说明
---|---|---
1 | -f, --force | 强制容器与网络断开连接