# 服务器 CentOS7 学习

## CentOS7 常用

### 切换 CentOS7 默认启动模式

- `vi /etc/inittab` (查看有哪些启动模式)
- multi-user.target: analogous to runlevel 3 (命令行模式)
- graphical.target: analogous to runlevel 5 (图形模式)(前提是已经安装了图形界面)
- 通过`systemctl get-default` 命令获取当前模式(注意：这里是：systemctl 是字母`l`,不是数字 1)
- 通过`systemctl set-default graphical.target` 命令，修改启动模式为图形界面启动(前提是：你安装了图形界面)
- 命令行启动模式则是`systemctl set-default multi-user.target`

### 更换国内源

1. ping 国内源,谁快用谁
   - `ping aliyun.com` (ping 阿里源)
   - `ping 163.com` (ping 网易源)
2. 备份源文件(也可以不备份)
   - `mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup`
3. 下载更改源
   - 根据 centos 版本下载对应的新源，这里以 CentOS7 为例
   - `wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo`
   - 如果 wget 命令不生效，说明还没有安装 wget 工具，输入 `yum -y install wget` 回车进行安装，或者使用
   - `curl -O http://mirrors.aliyun.com/repo/Centos-7.repo`
4. 清空 yum 缓存并生存 cache 文件
   - `yum clean all`
   - `yum makecache`
5. 尝试更新系统
   - `yum -y update`

### CentOS7 清理老旧内核

- uname -r(使用 uname -r 查看内核版本)
- rpm -q kernel(接着使用 rpm -q kernel 查看系统内所有的内核)
- yum remove 内核版本编号(相互对照，将老旧内核使用 yum remove 命令删除)

### 系统相关命令

- su root 或 su - (切换到 root 权限(与 su 有区别))
- logout (注销用户)
- shutdown -h now (理机关机) 等同于 halt
- shutdown -h 1 (1 分钟后关机)
- shutdown -r now (立即重启) 等同于 reboot
- sync (把内存数据写进磁盘,以免丢失(程序员的好习惯))
- 如果不进入 root 账号,可以在命令前加入 sudo 来以管理员权限执行

### 手动更新软件包 yum 安装器

- yum update -y (升级所有包同时也升级软件和系统内核)或 yum -y update (更新当前系统中安装的所有 rpm 包)
- yum upgrade (只升级所有包，不升级软件和系统内核)
- yum -y install [package] (下载并安装一个 rpm 包)
- yum localinstall [package.rpm] (安装一个 rpm 包，使用你自己的软件仓库解决所有依赖关系)
- yum update [package] (更新一个 rpm 包)
- yum remove [package] (删除一个 rpm 包)
- yum list (列出当前系统中安装的所有包)
- yum search [package] (在 rpm 仓库中搜寻软件包)
- yum clean [package] (清除缓存目录（/var/cache/yum）下的软件包)
- yum clean headers (删除所有头文件)
- yum clean all (删除所有缓存的包和头文件)

## 用户管理

### 添加用户

```md
useradd [选项] 用户名
实例:

useradd xm
会创建一个叫 xm 的用户,因为没有指定用户组,所以在创建用户 xm 的同时创建了一个同名(xm)的组,将用户 xm 分配到该组中(xm)
被创建的用户可以在/home/目录下查看(cd /home/)
cd : change directory 切换目录

cd /home/ (切换到 home 目录)
mkdir test (在 home 目录下创建文件夹)
useradd -d /home/test/ xh (创建新用户 xh 并分配到 test 目录下)
会有警告
建议不要先创建目录再分配,而是在创建用户的同时创建目录
useradd -d /home/test1 xh (创建目录 test1,创建用户 xh 并分配到 test1)
就不会有警告

指定密码
passwd 用户名
passwd xm (给用户 xm 更改密码)
然后输入密码即可
如果密码过短会收到警告,只需再输入一遍即可强制使用该密码
```

### 删除用户

```md
userdel 用户名
删除用户

1. 删除用户但保留家目录 userdel xm
2. 删除用户以及用户主目录 userdel -r xm
```

### 查询用户

```md
id 用户名
如果想知道当前我是什么用户可以用 whoami/who am i
```

### 切换用户

```md
su - 用户名
例如
su - root
su - wxz
exit 可推出当前用户
注意
su 后面不加用户是默认切到 root
su 是不改变当前变量
su - 是改变为切换到用户的变量
也就是说 su 只能获得 root 的执行权限，不能获得环境变量

而 su -是切换到 root 并获得 root 的环境变量及执行权限

一句话：要想真正的转换到 root 用户。使用 su - root
```

## 用户组

```md
添加用户组
groupadd 组名

删除组
groupdel 组名

添加用户时直接加上组
useradd -g 用户组 用户名

修改用户的组
usermod -g 用户组 用户名
```

## 实用命令

## vi 和 vim 的使用

### 常用命令

- esc (进入一般模式)
- i 或 o 或 a (编辑模式)
- : 或 / (命令模式)

### 命令模式下常用命令

- :wq (保存后退出)
- :q (退出)
- :q! (强制退出)

### 一般模式下常用命令

- yy (复制当前行) 5yy (复制当前向下的 5 行) p (并粘贴)
- dd (删除当前行) 5dd (删除当前向下的 5 行)
- /hello 然后 enter (当前文件查找 hello) n (查找下一个)
- (显示行号) :set nu (不显示行号) :set nonu
- G (到最末行) gg(到最顶行)
- u (撤回)
- 20 然后 shift+g (到指定的 20 行)
