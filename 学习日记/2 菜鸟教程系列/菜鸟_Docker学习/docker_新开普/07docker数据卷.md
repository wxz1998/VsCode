# docker 数据卷

## 数据卷的概念

Docker的理念：

* 将运用与运行的环境打包形成容器运行 ，运行可以伴随着容器，但是我们对数据的要求希望是持久化的
* 容器之间希望有可能共享数据

Docker容器产生的数据，如果不通过docker commit生成新的镜像，使得数据做为镜像的一部分保存下来，
那么当容器删除后，数据自然也就没有了。

为了能保存数据在docker中我们使用卷来实现。

> 类比 Redis中的 rdb 和aof文件

## 数据卷的作用

卷就是目录或文件，存在于一个或多个容器中，由docker挂载到容器，但不属于联合文件系统，因此能够绕过Union File System提供一些用于持续存储或共享数据的特性：

卷的设计目的就是数据的持久化，完全独立于容器的生存周期，因此Docker不会在容器删除时删除其挂载的数据卷

特点：

1. 数据卷可在容器之间共享或重用数据
2. 卷中的更改可以直接生效
3. 数据卷中的更改不会包含在镜像的更新中
4. 数据卷的生命周期一直持续到没有容器使用它为止

> 数据卷的作用总结：
>  
> 1. 容器的持久化
> 2. 容器间的继承和容器间的数据共享

### 数据卷举例

#### 1. 直接命令行形式添加

命令：

```shell
 docker run -it -v /宿主机绝对目录:/容器内目录 镜像名 /bin/bash

```

查看数据卷是否加载成功

```shell
docker inspect 容器ID

然后查找 "Volumes" 和 "VolumesRW"字样

```

容器与宿主机之间的数据共享

在容器内创建文件，宿主机内可以查看，执行
在宿主机内创建文件，在容器内可查看，执行

容器停止后，文件是否同步

1. 停止容器
2. 主机修改文件内容
3. 容器重启，进入
4. 查看主机修改过的文件内容，是否同步

带有读写权限的命令：

```shell
 docker run -it -v /宿主机绝对目录:/容器内目录:ro 镜像名 /bin/bash
ro: readonly
```

#### 2. DockerFile形式添加

1. 根目录下创建mydocker 文件夹并cd进入
2. 创建一个新的文件dockerfile，并且在dockerfile中 通过VOLUME 指令来给镜像添加一个或者多个数据卷

```shell
VOLUME["/dataVolumeContainer","/dataVolumeContainer2","/dataVolumeContainer3"]

说明：

出于可移植和分享的考虑，用-v 主机目录:容器目录这种方法不能够直接在Dockerfile中实现。
由于宿主机目录是依赖于特定宿主机的，并不能够保证在所有的宿主机上都存在这样的特定目录。
```

3. dockerfile的具体指令

```shell
    # volume test
    FROM centos
    VOLUME ["/dataVolumeContainer1","/dataVolumeContainer2"]
    CMD echo "finished,--------success1"
    CMD /bin/bash
```

4. build 生产docker镜像文件 newedu/centos:[v001]
5. docker 运行容器 docker run -it 镜像id /bin/bash
6. 查看宿主机上面对应的数据卷目录；默认地址为`/var/lib/docker/volumes/uid/data`目录

>Docker挂载主机目录Docker访问出现cannot open directory .: Permission denied
解决办法：在挂载目录后多加一个--privileged=true参数即可

### 数据卷容器[容器的继承]

#### 概念

命名的容器挂载数据卷，其它容器通过挂载这个(父容器)实现数据共享，挂载数据卷的容器，称之为**数据卷容器**

#### 操作演示说明

以上一个步骤创建的镜像 newedu/centos:[v001]为模板，分别创建三个实例dc001,dc002,dc003;
这三个实例，已经同时具有数据源/dataVolumesContainer1,/dataVolumesContainer2
(docker run -it --name dc001 newedu/centos:v001)
(docker run -it --name dc002 --volumes-from dc001 newedu/centos:v001)
(docker run -it --name dc003 --volumes-from dc001 newedu/centos:v001)

#### 具体的演示操作步骤

1. 启动一个父容器dc001。
2. 在dc001中的数据卷中添加文件。
3. 启动dc002,dc003,并且使用--volumes-from 参数继承自父容器dc001。
4. 操作并查看文件是否同步。

> 容器之间配置信息的传递，数据卷的生命周期一直持续到没有容器使用它为止。