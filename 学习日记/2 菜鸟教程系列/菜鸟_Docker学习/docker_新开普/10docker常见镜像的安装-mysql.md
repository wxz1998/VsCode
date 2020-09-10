# Mysql 的安装

操作步骤：

1. 搜索镜像
2. 拉取镜像
3. 查看镜像
4. 启动镜像
5. 停止镜像
6. 移除镜像

docker run -p 12345:3306 --name mysql -v /root/mysql/conf:/etc/mysql/conf.d -v /root/mysql/logs:/logs -v /root/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7

命令说明：
-p 12345:3306：将主机的12345端口映射到docker容器的3306端口。
--name mysql：运行服务名字
-v /root/mysql/conf:/etc/mysql/conf.d ：将主机/root/mysql录下的conf/my.cnf 挂载到容器的 /etc/mysql/conf.d
-v /root/mysql/logs:/logs：将主机/root/mysql目录下的 logs 目录挂载到容器的 /logs。
-v /root/mysql/data:/var/lib/mysql ：将主机/root/mysql目录下的data目录挂载到容器的 /var/lib/mysql
-e MYSQL_ROOT_PASSWORD=123456：初始化 root 用户的密码。
-d mysql:5.7 : 后台程序运行mysql5.7

docker exec -it MySQL运行成功后的容器ID     /bin/bash

## 外部mysql客户端连接mysql服务器

sqlyog

navicat

## 备份mysql数据库

docker exec myql服务容器ID sh -c ' exec mysqldump --all-databases -uroot -p"123456" ' > /root/all-databases.sql