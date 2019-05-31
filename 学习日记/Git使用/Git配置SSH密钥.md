# git ssh key配置&解决git推送每次都要输入密码

1. 检查一下用户名和邮箱是否配置在Git Bash Here工具下执行如下命令：
   - git config --global  --list
   - 如果已配置，则会显示自己的用户名及邮箱。
2. 如未配置，则执行以下命令进行配置：
   - git config --global  user.name "用户名"
   - git config --global user.email "邮箱"
3. 执行以下命令生成秘钥：
   - ssh-keygen -t rsa -C "邮箱"
   - 执行命令后需要进行3次或4次确认
4. 确认秘钥的保存路径（如果不需要改路径则直接回车）；
   - 如果上一步置顶的保存路径下已经有秘钥文件，则需要确认是否覆盖（如果之前②的秘钥不再需要则直接回车覆盖，如需要则手动拷贝到其他目录后再覆盖）；
   - 创建密码（如果不需要密码则直接回车）；
   - 确认密码；
5. 成功生成秘钥生成两个文件：
   - id_rsa
   - id_rsa.pub
   - Ubuntu下在 /.ssh/ 目录下，Windows下在个人文件里
6. 在指定的保存路径下会生成2个名为id_rsa及 id_rsa.pub的文件（命令窗口中有路径提示 .ssh）
7. 再打开你的github，进入配置页：
   - 点击setting
   - 选择SSH and GPG keys项
   - 点击右侧的New SSH key，进行添加
   - Tittle 随便填名字（方便记）
   - Key 填 id_rsa.pub 内的内容，全部复制