# Git删除本地仓库

- window环境下找到当前工程的目录
- 在当前目录，右击选择git bash here，点出git客户端
- 输入如下命令：
- //删除文件夹下的所有 .git 文件
- find . -name ".git" | xargs rm -Rf

- 其实就是找到 .git 文件夹删掉