
#include <stdio.h>
#define N 50 //宏定义100
int calculate(int save_array[], int len, int i)
{
    int j, save = 0;
    for (j = 0; j < len; j++) //变量j被约束在现有的变量len长度内
    {
        save += save_array[j] * i;
        save_array[j] = save % 10;
        save = save / 10;
    }
    while (save > 0) //判断变量以更新len变量的值
    {
        save_array[len] = save % 10;
        len++;
        save = save / 10;
    }
    return len; //返回更新的len变量
}
int main(void)
{
    int save_array[1000] = {0}; //声明一个足够大的数组
    int i, len = 1;
    int k, len_zero = 0;
    save_array[0] = 1;
    printf("%d的阶乘:\n", N);
    for (i = 2; i <= N; i++)
    {
        len = calculate(save_array, len, i); //调用用户自定义函数
    }
    for (i = len - 1; i >= 0; i--) //将数组保存的整数倒序排列
    {
        printf("%d", save_array[i]);
    }
    for (k = 0; k <= len - 1; k++)
    {
        if (save_array[k] == 0) //判断某一位数组是否为0
            len_zero++;         //数组某位为0则自增
        else
            break; //不为0直接跳出循环
    }
    printf("\n");
    printf("%d的阶乘后面有%d个0\n", N, len_zero);
    return 0;
}