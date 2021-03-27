# mysql

## 删除干净

- net stop mysqlID 关闭
- sc delete mysqlID 删除
- 通过 win+R,输入 regedit，进入注册表 `HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\右键查找 MySQL\删除`
