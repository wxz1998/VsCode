# 安装完mysql 关机需要10分钟

## 方法一

- 输入命令 sudo vim /etc/systemd/system/multi-user.target.wants/mysql.service
- 找到 TimeoutSec=600，将其修改成10，也就是10秒，保存即可。

## 方法二

- 每次关机前先关闭 MySQL 服务
- service mysql stop 关闭
- service mysql status 查看当前状态
- service mysql start 开启
