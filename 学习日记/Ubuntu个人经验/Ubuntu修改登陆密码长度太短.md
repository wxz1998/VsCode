# Ubuntu修改登陆密码长度太短或太简单

## 在安装 Ubuntu 的时候建立的帐户 wxz，想把密码改成4个字母 root，方便输入。

- 运行终端

- wxz@wxz-ubuntu:~$ passwd sai
- 更改 wxz 的密码。
- （当前）UNIX 密码： 8888
- 输入新的 UNIX 密码： root
- 重新输入新的 UNIX 密码: root
- 必须选择更长的密码
- 输入新的 UNIX 密码： 1234567
- 重新输入新的 UNIX 密码： 1234567
- Bad: new password is too simple
- 输入新的 UNIX 密码：

## 太短不让改怎么办？加上sudo权限执行即可。这样来做：

1. 方案一：
   - wxz@wxz-ubuntu:~$ sudo passwd wxz
   - [sudo] password for sai: 8888
   - 输入新的 UNIX 密码： root
   - 重新输入新的 UNIX 密码： root
   - passwd：已成功更新密码

2. 方案二：

   - wxz@wxz-ubuntu:~$ su
   - 密码： 8888
   - root@wxz-ubuntu:/home/wxz# passwd wxz
   - 输入新的 UNIX 密码： root
   - 重新输入新的 UNIX 密码： root
   - passwd：已成功更新密码
   - root@wxz-ubuntu:/home/wxz#