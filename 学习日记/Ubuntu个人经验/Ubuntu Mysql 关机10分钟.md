# 安装完mysql 关机需要10分钟

## 1.方法一

- 输入命令 sudo vim /etc/systemd/system/multi-user.target.wants/mysql.service
- 找到 TimeoutSec=600，将其修改成10，也就是10秒，保存即可。
