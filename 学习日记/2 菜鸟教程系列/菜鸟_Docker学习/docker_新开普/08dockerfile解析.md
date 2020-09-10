# DockerFile的解析

## 概念

DockerFile是用来构建docker镜像的源码文件（构建文件），是由一系列命令和参数组成的脚步文件。

构建的三步骤：

1. 编写dockerfile文件
2. docker build
3. docker run

可以从hub上查看某一个dockerfile的具体内容，
例如[centos](https://hub.docker.com/_/centos/)

## dockerfile的构建过程解析

dockerfile的基本知识：

1. 每条保留字指令都必须为答谢字母并且后面都要跟至少一个参数。
2. 指令按照从上到下顺序执行。
3. \# 表示注释。
4. 每条指令都会创建一个新的镜像层，并对镜像文件进行提交；类似于git的commit操作一样，所以为了让目标镜像体积小一些，所以应该尽量少的创建镜像层。

dockfile的大致流程：

1. docker从最最基础的镜像运行一个容器
2. 执行一条指令并对容器做出修改
3. 执行类似于docker commit的操作提交一个新的镜像层
4. docker基于刚提交的镜像，再次运行一个新的容器
5. 执行dockerfile中的下一条指令知道所有的指令都执行完成。

dockfile的执行过程总结：

从应用软件的角度来看，Dockerfile、Docker镜像与Docker容器分别代表软件的三个不同阶段，

* Dockerfile是软件的原材料
* Docker镜像是软件的交付品
* Docker容器则可以认为是软件的运行态。

Dockerfile面向开发，Docker镜像成为交付标准，Docker容器则涉及部署与运维，三者缺一不可，合力充当Docker体系的基石。

![dockerfile与docker镜像示意图](/images/docker8.png)

1. Dockerfile，需要定义一个Dockerfile，Dockerfile定义了进程需要的一切东西。Dockerfile涉及的内容包括执行代码或者是文件、环境变量、依赖包、运行时环境、动态链接库、操作系统的发行版、服务进程和内核进程(当应用进程需要和系统服务和内核进程打交道，这时需要考虑如何设计namespace的权限控制)等等;

2. Docker镜像，在用Dockerfile定义一个文件之后，docker build时会产生一个Docker镜像，当运行 Docker镜像时，会真正开始提供服务;

3. Docker容器，容器是直接提供服务的。

### dockerfile的保留字指令



| 编号 | 保留字     | 说明                                                         |
| ---- | ---------- | ------------------------------------------------------------ |
| 1    | FROM       | 基础镜像，当前新镜像是基于哪个镜像的                         |
| 2    | MAINTAINER | 镜像维护者的姓名和邮箱地址                                   |
| 3    | RUN        | 容器构建时需要运行的命令                                     |
| 4    | EXPOSE     | 当前容器对外暴露出的端口                                     |
| 5    | WORKDIR    | 指定在创建容器后，终端默认登陆的进来工作目录                 |
| 6    | ENV        | 用来在构建镜像过程中设置环境变量                             |
| 7    | ADD        | 将宿主机目录下的文件拷贝进镜像并且ADD命令会自动处理URL和解压tar压缩包 |
| 8    | COPY       | 类似ADD，拷贝文件和目录到镜像中。将从构建上下文目录中<源路径>的文件/目录 复制到 新的一层镜像内的 <目标路径>位置。 |
| 9    | VOLUME     | 容器数据卷，用于数据保存和持久化工作                         |
| 10   | CMD        | 指定一个容器启动时要运行的命令；可以有多条CMD指令。CMD会被ocker run之后的参数替换 |
| 11   | ENTRYPOINT | 指定一个容器启动时要允许的命令，与CMD一样的作用，都是在指定容器启动程序及参数；区别：执行docker实例指定的参数，ENTRYPOINT 命令作用是参数 append 附加作用，而CMD时命令的替换作用。 |
| 12   | ONBUILD    | 当构建一个被继承的Dockerfile时运行命令，父镜像在被子继承后父镜像的onbuild被触发 |
|      |            |                                                              |

>备注
>ENV MY_PATH /usr/mytest
这个环境变量可以在后续的任何RUN指令中使用，这就如同在命令前面指定了环境变量前缀一样；
也可以在其它指令中直接使用这些环境变量，
>
>比如：WORKDIR $MY_PATH

![dockefile指令示意图](/images/docker9.png)


### dockerfile的案例

自定义镜像tomcat9

具体的操作步骤：

1. 创建一个临时目录 mkdir -p ~/mydockerfile/tomcat9
2. 进入目录 cd ~/mydockerfile/tomcat9，并创建一个测试文件a.txt ,touch a.txt
3. 将jdk和tomcat安装的压缩包拷贝进上一步目录。apache-tomcat-9.0.8.tar.gz ，jdk-8u171-linux-x64.tar.gz
4. 在~/mydockerfile/tomcat9目录下新建Dockerfile文件
5. dockerfile 的构建 build
6. docker 镜像的运行 run
7. 验证
8. 结合数据卷，进一步测试tomcat的web发布功能。

![dockerfile操作示意图](/images/docker10.png)