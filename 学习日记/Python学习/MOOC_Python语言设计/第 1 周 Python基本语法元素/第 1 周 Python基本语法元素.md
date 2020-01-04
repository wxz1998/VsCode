# 第 1 周 Python基本语法元素

## 1.1 程序设计基本方法

- IPO

## 1.2 Python开发环境配置

- 计算圆面积

```py
r = 25
area = 3.1415 * r * r
print(area)
print("{:.2f}".format(area))
```

- 同切圆绘制

```py
import turtle
turtle.pensize(2)
turtle.circle(10)
turtle.circle(40)
turtle.circle(80)
turtle.circle(160)
```

- 五角星绘制

```py
from turtle import *
color('red','red')
begin_fill()
for i in range(5):
    fd(200)
    rt(144)
end_fill()
done()
```

## 1.3 实例1 温度转换

### 需求分析

- 摄氏度转换为华氏度
- 华氏度转换为摄氏度

### 设计算法

```text
C = (F - 32) / 1.8
F = C * 1.8 + 32
```

### 编程

```py
#TempConvert.py
TempStr = input("请输入带有符号(C或F)的温度值:")
if TempStr[-1] in ['F','f']:
    C = (eval(TempStr[0:-1]) - 32)/1.8
    print("转换后的摄氏温度是{:.2f}C".format(C))
elif TempStr[-1] in ['C','c']:
    F = 1.8 * eval(TempStr[0:-1]) + 32
    print("转换后的华氏温度是{:.2f}F".format(F))
else:
    print("输入格式错误(FfCc)")
```
