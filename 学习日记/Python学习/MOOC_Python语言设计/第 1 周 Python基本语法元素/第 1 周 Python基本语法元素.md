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
