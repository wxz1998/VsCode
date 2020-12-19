# 源码获取

## OpenHarmony 介绍

OpenHarmony 是 HarmonyOS 的开源版，由华为捐赠给开放原子开源基金会（OpenAtom Foundation）开源。第一个开源版本支持在 128KB~128MB 的设备上运行，欢迎参加开源社区一起持续演进。

代码仓库地址：[https://openharmony.gitee.com](https://openharmony.gitee.com/)

说明

当前的 OpenHarmony 源代码仅支持在 Linux 环境下编译，如果在 Windows 下使用，可能会出现异常。

例如，某些组件在下载安装时需要调用 Linux 命令来设置环境变量，如果在 Windows 环境下操作可能就会报错。遇到此问题时可以尝试先将 hpm 的 shell 改为第三方的 shell，例如改为 git 的 sh.exe，可通过执行以下命令修改 shell：

hpm config set shellPath 'C:\Program Files\Git\bin\sh.exe'

## 源码获取概述

本文档将介绍如何获取 HarmonyOS 源码并说明 HarmonyOS 的源码目录结构。HarmonyOS 的代码以[组件](https://device.harmonyos.com/cn/docs/develop/bundles/oem_bundle_standard_des-0000001050129846)的形式开放，开发者可以通过如下其中一种方式获取：

- **获取方式 1**：从镜像站点下载压缩文件（推荐）
- **获取方式 2**：从 hpm 网站组件式获取。通过[HPM](https://hpm.harmonyos.com/)，查找满足需求的解决方案，挑选/裁剪组件后下载。
- **获取方式 3**：用包管理器命令行工具获取。通过[HPM](https://hpm.harmonyos.com/)的 hpm-cli 命令行工具，执行命令下载。
- **获取方式 4**：从代码仓库获取。通过 repo 或 git 工具从代码仓库中下载。

## 获取方式 1：从镜像站点获取

为了获得更好的下载性能，您可以选择从以下站点的镜像库获取源码或者对应的解决方案。

| 下载内容                  | 版本信息 | 下载站点                                                                              | SHA256 校验码                                                                                         |
| ------------------------- | -------- | ------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| 全量代码                  | 1.0      | [站点](https://repo.huaweicloud.com/harmonyos/os/1.0/code-1.0.tar.gz)                 | [SHA256 校验码](https://repo.huaweicloud.com/harmonyos/os/1.0/code-1.0.tar.gz.sha256)                 |
| Hi3861 解决方案（二进制） | 1.0      | [站点](https://repo.huaweicloud.com/harmonyos/os/1.0/wifiiot-1.0.tar.gz)              | [SHA256 校验码](https://repo.huaweicloud.com/harmonyos/os/1.0/wifiiot-1.0.tar.gz.sha256)              |
| Hi3518 解决方案（二进制） | 1.0      | [站点](https://repo.huaweicloud.com/harmonyos/os/1.0/ipcamera_hi3518ev300-1.0.tar.gz) | [SHA256 校验码](https://repo.huaweicloud.com/harmonyos/os/1.0/ipcamera_hi3518ev300-1.0.tar.gz.sha256) |
| Hi3516 解决方案（二进制） | 1.0      | [站点](https://repo.huaweicloud.com/harmonyos/os/1.0/ipcamera_hi3516dv300-1.0.tar.gz) | [SHA256 校验码](https://repo.huaweicloud.com/harmonyos/os/1.0/ipcamera_hi3516dv300-1.0.tar.gz.sha256) |
| RELEASE-NOTES             | 1.0      | [站点](https://repo.huaweicloud.com/harmonyos/os/1.0/RELEASE-NOTES.txt)               | -                                                                                                     |

## 获取方式 2：从 HPM 网站组件式获取

### 适用场景

对于刚接触 HarmonyOS 的新用户，希望能够参考一些示例解决方案从而进行快速开发。可以在[HPM](https://hpm.harmonyos.com/)获取推荐的解决方案，以此为基础，增加或裁剪部分组件，快速定制系统。

### 操作步骤

1. 查找合适的解决方案组件包。

   1. 打开包管理页面[HPM](https://hpm.harmonyos.com/)，设定搜索的对象为“解决方案”，如下图所示。

   2. 自搜索框输入关键字搜索，如"camera"。

   3. 结果中显示匹配的解决方案，可以进一步根据组件类别等过滤条件(如：适配的开发板，内核）精确筛选。

   4. 查找合适的解决方案，点击查看解决方案详情介绍。

      **图 1** 包管理

      ![点击放大](https://communityfile-drcn.op.hicloud.com/FileServer/getFile/cmtyPub/011/111/111/0000000000011111111.20201123092205.87029876660013868933144667613271:50511123012636:2800:093ABCAE26981EDE9FC7632271ED3B49A9940F8265EF4D1BC62953DA5608AF05.png?needInitFileName=true?needInitFileName=true)

2. 定制解决方案组件包。

   1. 仔细阅读解决方案的说明，以了解该解决方案的使用场景、特性、使用方法以及如何进行定制化，如下图所示。
   2. 点击「直接下载」，将解决方案下载到本地。
   3. 点击「定制组件」，将对解决方案包含的组件进行定制。

   **图 2** 解决方案示例

   ![点击放大](https://communityfile-drcn.op.hicloud.com/FileServer/getFile/cmtyPub/011/111/111/0000000000011111111.20201123092205.44093937889393251176583798860751:50511123012636:2800:BAAED533097EE4133D99DAB2EE7EDBF7139322315FD37E156B18E4BB22716067.png?needInitFileName=true?needInitFileName=true)

3. 定制组件。

   1. 进入解决方案定制页面，如下图所示。

   2. 通过关闭开关移除可选组件，或者通过“添加组件”增加新的组件。

   3. 在右边填写您的项目基本信息，包括名称、版本、描述等信息。

   4. 点击

      “下载”

      ，系统会根据您的选择，生成相应的

      HarmonyOS

      代码结构文件(如 name.zip)，保存至本地文件。

      - 下载的压缩文件并未包含源代码的原始文件，可以在 IDE 中导入下载的压缩包，解压后执行 hpm 的安装指令(hpm install），才会将所需要的组件全部下载下来。

      - 下载的组件存在工程目录下的 ohos_bundles 文件夹中。

        **图 3** 组件定制

        ![点击放大](https://communityfile-drcn.op.hicloud.com/FileServer/getFile/cmtyPub/011/111/111/0000000000011111111.20201123092205.72445255656996676237540887058005:50511123012636:2800:ADC25F8FF804113DA03554473B109FCDCDBD085668E1798D67A8CF2FE7A28F46.png?needInitFileName=true?needInitFileName=true)

## 获取方式 3：用包管理器命令行获取

### 适用场景

- 用户已通过组件式获取的方式获取源码，需要对源码中的某个或某几个组件进行独立升级。
- 用户已经比较熟悉 HarmonyOS 系统的开发并且熟练掌握命令行工具的使用。

### 准备

通过命令行获取，需要先安装 Node.js 和 hpm 命令行工具，安装步骤如下：

1. 安装 Node.js。

   官网下载并在本地安装 Node.js.

   推荐安装 [Node.js](https://nodejs.org/) 12.x (包含 npm 6.14.4)或更高版本 (推荐 12.13.0+)。

2. 通过 Node.js 自带的 npm 安装 hpm 命令行工具。

   打开 CMD，执行以下命令：

   ```shell
   npm install -g @ohos/hpm-cli
   ```

3. 安装完成后执行如下命令，显示 hpm 版本，即安装成功。

   ```shell
   hpm -V 或 hpm --version
   ```

4. 如果升级 hpm 的版本，请执行如下命令：

   ```shell
   npm update -g @ohos/hpm-cli
   ```

### 操作

接下来将组件添加到开发项目中，假定要获取的组件名为@ohos/demo，具体操作如下：

1. 进入开发目录，执行如下命令，采用默认模板创建一个开发项目。

   ```shell
   hpm init -t default
   ```

2. 执行如下命令，安装组件@ohos/demo

   ```shell
   hpm install @ohos/demo
   ```

3. 工具会自动从服务器下载所有依赖的组件，下载成功则显示 Install successfully!

   ```shell
   $ hpm install @ohos/demoRequesting: https://url.foo.bar/hpm/registry/api/bundles/@ohos/demodownloading @ohos/demoRequesting: https://lfcontentcenterdev....../bMAlLrYISLqdUTFFFCdgzA.tgzextract D:\demo\ohos_bundles\@ohos\demo\@ohos-demo-1.0.7.tgzInstall successfully!
   ```

## 获取方式 4：从代码仓库获取

### 适用场景

- 基于 HarmonyOS 的稳定分支建立自己的基线，分发下游客户。
- 已经完成自身软件与 HarmonyOS 的对接，需要进行 HarmonyOS 官方认证。
- 芯片/模组/app 通过 HarmonyOS 官方认证后，贡献代码到 HarmonyOS 生态。
- 修复 HarmonyOS 的问题。
- 学习 HarmonyOS 的源码。

### 准备

1. 注册码云 gitee 账号。

2. 注册码云 SSH 公钥，请参考码云帮助中心的公钥管理：https://gitee.com/help/articles/4181

3. 安装 git 客户端并配置用户信息。

   ```shell
   git config --global user.name "yourname"git config --global user.email "your-email-address"git config --global credential.helper store
   ```

4. 安装码云 repo 工具，可以执行如下命令。

   ```shell
   curl https://gitee.com/oschina/repo/raw/fork_flow/repo-py3 > /usr/local/bin/repochmod a+x /usr/local/bin/repopip install -i https://pypi.tuna.tsinghua.edu.cn/simple requests
   ```

### 操作

方式一（推荐）：通过 repo 下载

```shell
repo init -u https://gitee.com/openharmony/manifest.git -b master --no-repo-verifyrepo sync -c
```

方式二：通过 git clone 单个代码仓库

进入[代码仓库主页](https://gitee.com/openharmony)，选择需要克隆的代码仓库，执行命令，如：

```shell
git clone https://gitee.com/openharmony/manifest.git -b master
```

## 源码目录简介

下表是 HarmonyOS 源码的目录及简单说明：

| 目录名       | 描述                                   |
| ------------ | -------------------------------------- |
| applications | 应用程序样例，包括 wifi-iot，camera 等 |
| base         | 基础软件服务子系统集&硬件服务子系统集  |
| build        | 组件化编译、构建和配置脚本             |
| docs         | 说明文档                               |
| domains      | 增强软件服务子系统集                   |
| drivers      | 驱动子系统                             |
| foundation   | 系统基础能力子系统集                   |
| kernel       | 内核子系统                             |
| prebuilts    | 编译器及工具链子系统                   |
| test         | 测试子系统                             |
| third_party  | 开源第三方组件                         |
| utils        | 常用的工具集                           |
| vendor       | 厂商提供的软件                         |
| build.py     | 编译脚本文件                           |
