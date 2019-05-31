# Ubuntu18.04安装MySQL8.0

- 直接使用apt install mysql-server安装，那么恭喜你踩坑。
- sudo apt install mysql-server默认会安装MySQL 5.7，将会出现一些莫名的问题，例如：安装过程没有要求输入root密码，而登录mysql时会要求密码（我就是遇到了这个问题，结果搞了一下午╮(╯▽╰)╭）等等……
- 阅读了一下MySQL安装指南，发现MySQL5.7版本最高只适配到Ubuntu17.04，而MySQL8.0最高适配到Ubuntu18.04。
- So，去 http://dev.mysql.com/downloads/repo/apt/ .下载一个mysql-apt-config_0.*.****_all.deb，使用
- sudo dpkg -i mysql-apt-config_0.*.****_all.deb
- 安装执行
- 选择mysql-8.0 并按enter键
- 再次选择mysql-8.0 并按enter键
- 选择ok 并按enter键
- 然后更新 apt-get update 一下
- 正式安装MySQL18.04：sudo apt install mysql-server
- 上边安装完后，会让你设置root密码，输入后按enter键，并再次确认
- MySQL8.0采用了新的加密方式，与Ubuntu18.04有兼容问题；
故选择下面的旧版本5.x的加密方式
- 最后在终端输入mysql -u root -p命令并输入密码检查安装成功而且可以看到MySQL版本号为8.0！！