# npm 更新所有依赖包

## 通过 shell 更新 npm 包

- npm -g outdated (通过 npm -g outdated 可以查看那些包有更新)
- 列出来了，当前版本，和最后的版本，只需要得到所有需要升级的包名和版本号就可以使用 npm -g install <name>直接升级了

## 通过 npm-check 来更新(可行)

- npm install -g npm-check (安装)
- npm-check -u -g 检查 npm (包的状态)
- 通过上下键可以移动光标，使用空格键可以选择需要处理的包，回车直接进行处理

## 通过工具 npm-check-updates 来更新

全局安装 npm-check-updates

```shell
npm install -g npm-check-updates
```

## 检查可更新的包

在当前项目的目录下执行以下命令，查看所有存在的更新

```shell
ncu
```

也可以通过执行以下命令查看所有可用的相关命令行(命令变动或者无效时查看命令)

```shell
ncu -h
```

\##更新包

```shell
ncu -u
```

## 使用心得

在使用过程中，使用该命令更新了项目中的包，并执行 npm install,重新安装包，但是更新完成后发现项目运行不起来！！！！

> 注意：npm-check-updates 是更新项目包，但是无法保证包之间的依赖关系，导致项目无法运行，因此更新前一定要做好备份，以方便存在问题的时候恢复

> 因此轻易不要执行，可以查看所有存在的更新，选择性的手动更新
