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
