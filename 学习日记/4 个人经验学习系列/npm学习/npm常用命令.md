# npm

## npm 自身更新

- npm install npm -g

## npm 检查版本

- npm --version 或 npm -v (win10)

# npm 更换成淘宝镜像源以及 cnpm

1.需求由来

由于 node 安装插件是从国外服务器下载，受网络影响大，速度慢且可能出现异常。所以如果 npm 的服务器在中国就好了，所以我们乐于分享的淘宝团队（[阿里巴巴](https://links.jianshu.com/go?to=https%3A%2F%2Fbaike.baidu.com%2Fitem%2F%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4%E9%9B%86%E5%9B%A2%2F9087864%3Ffromtitle%3D%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4%26fromid%3D33)旗下业务[阿里云](https://links.jianshu.com/go?to=https%3A%2F%2Fbaike.baidu.com%2Fitem%2F%E9%98%BF%E9%87%8C%E4%BA%91)）干了这事。来自官网：“这是一个完整 npmjs.org 镜像，你可以用此代替官方版本(只读)，同步频率目前为 10 分钟 一次以保证尽量与官方服务同步。

也就是说我们可以使用阿里布置在国内的服务器来进行 node 安装。

2.使用方法

1.使用阿里定制的 cnpm 命令行工具代替默认的 npm，输入下面代码进行安装：

```shell
$ npm install -g cnpm --registry=https://registry.npm.taobao.org
```

2.检测 cnpm 版本，如果安装成功可以看到 cnpm 的基本信息。

```shell
cnpm -v
```

3.以后安装插件只需要使用`cnpm intall`即可

---

> 假如我已经习惯了`npm install`的安装方式，我不想去下载阿里的 cnpm 命令工具将命令变成 cnpm 怎么办？很容易我们想到，我直接将 node 的仓库地址改成淘宝镜像的仓库地址不就好了吗？

3.单次使用

```shell
npm install --registry=https://registry.npm.taobao.org
```

4.永久使用

设置成全局的下载镜像站点，这样每次 install 的时候就不用加--registry，默认会从淘宝镜像下载，设置方法如下：

```
1.打开.npmrc文件（nodejs\node_modules\npm\npmrc，没有的话可以使用git命令行建一个( touch .npmrc)，用cmd命令建会报错）
2.增加 registry =https://registry.npm.taobao.org  即可。
```

也可以按如下方式直接在命令行设置

```shell
npm config set registry https://registry.npm.taobao.org
```

检测是否成功

```shell
// 配置后可通过下面方式来验证是否成功
npm config get registry
// 或
npm info express
```

这样，我们可以使用淘宝镜像还不用更换成 cnpm,是不是很爽！虽然实际都是使用的是淘宝镜像。
最后附上淘宝镜像官网地址：[http://npm.taobao.org/](https://links.jianshu.com/go?to=http%3A%2F%2Fnpm.taobao.org%2F)

**注：**如果想还原 npm 仓库地址，只需再把地址配置成 npm 镜像就可以了

```shell
   npm config set registry https://registry.npmjs.org/
```

5.npm 改成淘宝镜像与 cnpm 区别（20190509 新增）

之前一直以为 npm 改成淘宝镜像后和 cnpm 本质是一样的，今天在研究 package-lock.json 时候发现，这两者还是有很大区别。特记录下：

先贴下截图对比： 1.使用 cnpm 安装 lodash

![img](C:\Users\wxz18\VsCode\学习日记\4 个人经验学习系列\npm 学习\npm 常用命令.assets\1894758-0a05d59e484d0fce.png)

2.使用改成淘宝仓库的 npm 安装 lodash

![img](C:\Users\wxz18\VsCode\学习日记\4 个人经验学习系列\npm 学习\npm 常用命令.assets\1894758-b6e9ca9c369f1fe4.png)

npm.png

通过截图会发现：

- cnpm 安装模块的时候会在 node\*modules 文件夹生成二个文件夹，一个以下划线 \*\*\*\*\*开头以及版本号组成的名字，一个正常名字的模块，文件夹名字虽然不一样，但里面文件是一样的。
  比如执行 cnpm install lodash,会在 node_modules 文件夹下生成两个文件夹：_lodash@4.17.11@lodash 和 lodash，

- 先执行了 cnpm install lodash，然后再执行 npm install lodash，npm 安装的 lodash 会替换掉 cnpm 安装的 lodash 包（包括以下划线开头那个包），文件夹会只剩一个 npm 先安装的 lodash 包。再次 npm uninstall lodash 或者 cnpm uninstall lodash,都会删除 lodash 包，此时插件包就变成空文件夹了。

- 先执行了 cnpm install lodash，然后再执行 npm uninstall lodash 后，此时会报错

  ```shell
   npm ERR! code EINVALIDPACKAGENAME

   npm ERR! Invalid package name "_lodash@4.17.11@lodash": name cannot start with an underscore;

   name can only contain URL-friendly characters
  ```

但是使用 cnpm uninstall lodash 后，不会报错，此时会删掉 cnpm 安装的两个包中其中一个即非下划线（正常名字）的包。剩余的那个包是可以正常通过鼠标点击打开的。然后在文件中 require 会报错，提示没有这个包。

- 先执行了 cnpm install lodash，然后手动删除 cnpm 安装的两个包中其中一个即下划线（非正常名字）的包，剩余的那个包，发现无法通过鼠标点击打开了。然后在文件中 require 会报错，提示没有这个包。

![img](C:\Users\wxz18\VsCode\学习日记\4 个人经验学习系列\npm 学习\npm 常用命令.assets\1894758-76473876c15c514b.png)

yinyong.png

- 所以，cnpm 安装的的 2 个模块，两者应该存在引用关系，正常名字模块是非正常名字模块的索引，两者都必须存在才可以使用。但是 npm 安装下来就不存在这种情况了，因为只有一个正常名字模块。
- 实测发现，尽管使用 npm 改成淘宝仓库，发现安装速度还是远远比 cnpm 慢（当模块比较多的时候）。可能应该和 cnpm 安装的文件结构有关系吧。
