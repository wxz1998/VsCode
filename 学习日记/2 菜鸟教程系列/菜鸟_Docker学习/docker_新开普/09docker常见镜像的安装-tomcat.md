# tomcat的安装

操作步骤：

1. 搜索镜像
2. 拉取镜像
3. 查看镜像
4. 启动镜像
5. 停止镜像
6. 移除镜像

```shell
docker search tomcat
docker pull tomcat
docker images
docker run -it -p 8080:8080 tomcat
```