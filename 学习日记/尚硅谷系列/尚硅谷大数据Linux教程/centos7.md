# 服务器 CentOS7 学习

## CentOS7 常用命令

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

### 用户管理

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
