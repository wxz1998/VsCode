# docker 镜像

## 定义

docker的镜像是一种轻量级、可执行的独立软件包，用来打包软件运行环境和基于运行环境开发的软件，它包含运行某个软件所需的所有内容，包括代码、运行时、库、环境变量和配置文件

docker镜像 是只读的；当容器启动时，一个新的可写层被加载到容器的顶层，这一层通常被称作“容器层”，“容器层”之下的被称为“镜像层”。

## 镜像的操作

### commit

docker commit ：提交镜像副本使之成为一个新的镜像
docker commit -m="提交的注释信息" -a="作者信息" 容器id 要创建的目标镜像名:[标签名]

### tag

docker tag : 修改镜像的名称和便签
docker tag  镜像老名称:标签名  镜像新名称:标签名

### login

docker login : 登录docker hub

### push

docker push : 将镜像推送到自己的docker hub仓库中
docker push  镜像名称:标签名
注：镜像名称=docker hub用户名/仓库名时才能推送成功，否则推送失败

## 案例

### 定制一个属于自己的docker镜像

以tomcat为例讲解

1. 从docker hub中 下载 tomcat的镜像到本地，并成功运行。
2. 进入docker的实例，删除官方标准版中的tomcat的doc说明文件夹。
3. 以没有doc说明文档的tomcat docker实例为模板，制作属于自己的tomcat镜像，名字为 newedu/tomcat001:[v01]。
4. 启动新的tomcat镜像newedu/tomcat001:[v01],并与官方标准版的tomcat镜像对比。

#### 具体操作示意图
