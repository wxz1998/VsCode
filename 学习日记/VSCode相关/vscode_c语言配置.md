# vscode_c语言配置

```txt
"code-runner.executorMap": {
    "javascript": "node",
    "java": "cd $dir && javac -finput-charset=UTF-8 -fexec-charset=GBK $fileName && java $fileNameWithoutExt",
    "c": "cd $dir && gcc -finput-charset=UTF-8 -fexec-charset=GBK $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt",
    "cpp": "cd $dir && g++ -finput-charset=UTF-8 -fexec-charset=GBK $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt"
  }
```