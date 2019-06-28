# 利用CloudStudio建立MC服务器

## 第一步

- 在CloudStudio内建立一个JavaDemo项目
- 然后建两个文件夹
- frp（用来存放sakurafrp的内网穿透端口）
- mkdir frp
- mcserver（用来存放mc服务器）
- mkdir mcserver

## 第二步

- 去mcversions.net下载自己需要的mc服务器jar包版本
- 例如我是1.12
- 复制其链接地址
- 在mcserver下用命令下载
- wget https://launcher.mojang.com/v1/objects/8494e844e911ea0d63878f64da9dcc21f53a3463/server.jar
- 下面步骤在第三步之后完成最好
- 启动java虚拟机
- java -Xmx1024M -Xms1024M -jar -server.jar nogui
- 第一次可能会停止运行，因为cloudstudio硬件配置太差
- 改一下启动配置
- 打开mcserver下eula.txt
- 把eula=false改成true
- 再次启动，完成
- stop命令可以退出mc服务器
- 如果是盗版mc则需要把server.properties下的online-mode=true改成false

## 第三步

- 下载sakurafrp的linux64位版本
- wget https://cdn.tcotp.cn:4443/client/Sakura_frpc_linux_amd64.tar.gz
- 然后解压
- tar -xzvf Sakura_frpc_linux_amd64.tar.gz
- 解压后打开
- ./Sakura_frpc_linux_amd64
- 然后登录自己的账户
- wxz
- wxz199841215
- 选择一个服务器ID
- 例如我选择 4
- 确认
- 服务器搭建好了
