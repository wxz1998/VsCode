# npm 前端项目

- 心得:
- node.js 与 jQuery,vue.js 等 js 框架差不多,本质依然是 js 框架
- 但 node.js 除了有一般 js 框架功能(封装好许多 js 函数方法),还能打包 js 组件
- 我们可以写出自己的 js 组件,利用 node.js 进行打包发布,同样可以下载别人发布的
- npm 也是一个封装好的 js 组件,node.js 默认自带
- 利用 npm 可以下载别人的 js 包,并进行管理

## npm 对前端项目的包管理(注意:只是管理)

- 纯前端项目,使用 npm 对包进行管理
- npm init (项目根目录初始化) 最好写成 npm init -y (默认全 yes,不然有很多选项需要选)
- 会创建一个 package.json 的配置文件
- 然后利用 npm 下载 js 包,会在本地创建 node_modules 文件夹

### npm i (npm install)

- 如果提前写好了 package.json,只需 npm i 命令即可下载配置文件内以经写进去的包
- 例如下载了别人的前端项目,里面只有 package.json,没有 node_modules,执行 npm i,就可以下载好配置文件内的环境需求了

### 删除

- 如需删除 node_modules 目录下面的包（package），请执行：
- `npm uninstall <package>`
- 如需从 package.json 文件中删除依赖，需要在命令后添加参数 --save:
- `npm uninstall --save lodash`
- 注意：如果你将安装的包作为 "devDependency"（也就是通过 --save-dev 参数保存的），那么 --save 无法将其从 package.json 文件中删除。所以必须通过 --save-dev 参数可以将其卸载。
- 为了确定 npm uninstall 命令执行成功，请找到 node_modules 目录，并在此目录下检查你所卸载的包（package）所对应的目录是否消失了。

## npm 创建 vue 项目(注意:是创建)
