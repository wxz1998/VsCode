# VSCode问题总结

## 问题1：VSCode终端cmd和powershell显示不正常,鼠标无法点击,输入命令显示不正常

- 解决方法：两个方法，第一个是换回旧版cmd（打开cmd，右键窗体，属性，换回旧版），第二个是改设置用bash（在VSCode设置里面将默认终端配置为GitBash）。

## 问题2：新版 VS Code 如何设置中文

- 刚刚安装的VSCode软件默认使用的是英文语言环境
- 这里需要使用快捷键【Ctrl+Shift+P】来实现
- 在弹出的搜索框中输入【configure language】
- 然后选择搜索出来的【Configure Display Language】
- 如果没有中文选项就点击安装其他语言
- 安装中文，然后再选择它即可

## 问题3：Ubuntu 下更新visualstuido code

- wget https://vscode-update.azurewebsites.net/latest/linux-deb-x64/stable -O /tmp/code_latest_amd64.deb 
- sudo dpkg -i /tmp/code_latest_amd64.deb
