# CentOS7 的学习机器的操作日志

## 安装好之后立马先修改默认启动模式

- `systemctl get-default` (查看当前启动模式)
- `systemctl set-default multi-user.target` (设置为默认命令行启动模式)
- `reboot` (重启看看)(成功)

## 更新一下

- `yum -y update` (yum 更新,内核和软件包全部更新)
- 没想到更新速度挺快,但还是想换源

## 换源

- `su root`
- `cd /etc/yum.repos.d/` (看看默认源)
- `mkdir repo_bak` (给默认源创建一个备份文件夹)
- `mv *.repo repo_bak/` (都给移进去)
- `[root@centos7 yum.repos.d]# wget http://mirrors.aliyun.com/repo/Centos-7.repo`(下载阿里的 yum 源)
- `[root@centos7 yum.repos.d]# wget http://mirrors.163.com/.help/CentOS7-Base-163.repo`(网易的)

```txt
查看一下:成功
[root@centos7 yum.repos.d]# ls
CentOS7-Base-163.repo  Centos-7.repo  repo_bak
```

```txt
清除系统yum缓存并生成新的yum缓存

清除系统所有的yum缓存
[root@centos7 yum.repos.d]# yum clean all

生成yum缓存
[root@centos7 yum.repos.d]# yum makecache
```

```txt
安装epel源
[root@centos7 yum.repos.d]# yum list | grep epel-release

[root@centos7 yum.repos.d]# yum install -y epel-release

[root@centos7 yum.repos.d]# ls
CentOS7-Base-163.repo  Centos-7.repo  epel.repo  epel-testing.repo  repo_bak

使用阿里开源镜像提供的epel源
[root@centos7 yum.repos.d]# wget -O /etc/yum.repos.d/epel-7.repo http://mirrors.aliyun.com/repo/epel-7.repo

[root@centos7 yum.repos.d]# ls
CentOS7-Base-163.repo  Centos-7.repo  epel-7.repo  epel.repo  epel-testing.repo  repo_bak

再次清除系统yum缓存，并重新生成新的yum缓存
[root@centos7 yum.repos.d]# yum clean all

[root@centos7 yum.repos.d]# yum makecache

查看系统可用的yum源和所有的yum源
[root@centos7 yum.repos.d]# yum repolist enabled

[root@centos7 yum.repos.d]# yum repolist all
```

## 有了旧内核 删吧

```txt
查看一下内核
[wxz@centos7 ~]$ uname -r
3.10.0-1160.11.1.el7.x86_64

查看所有内核信息
[wxz@centos7 ~]$ rpm -q kernel
kernel-3.10.0-1062.el7.x86_64
kernel-3.10.0-1160.11.1.el7.x86_64

得管理员才能删
[wxz@centos7 ~]$ su root

删除旧的
[root@centos7 wxz]# yum remove kernel-3.10.0-1062.el7.x86_64
```
