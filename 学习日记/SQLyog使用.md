# SQLyog 相关

## 如何永远试用 SQLyog 试用版

- 在 “开始” 文本框  输入 regedit.exe   进入注册表：
- 在 \HEYK_CURRENT_USER\Software\{FCE28CE8-D8CE-4637-9BC7-93E4C0D407FA}
- (名字不一定和这个完全一样)一般为第一个很长的值
- 其中InD保存着 SQLyog 的使用天数
- 十进制值2455140～2455131表示30～1天，该区间外的数值应该均为0天，所以每次可以更改该数值便可一直试用。
- 也可以直接删除InD值,再打开 SQLyog, 你的 sqlyog 又可以继续试用
