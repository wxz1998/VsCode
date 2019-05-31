#include <stdio.h>
int main(void) {
  int N;
  int i;
  char temp;
  char ch1[3];
  scanf("%d", &N);
  getchar();
  while (N--) {
    for (i = 0; i < 3; i++) {
      scanf("%c", &ch1[i]);
    }
    getchar();
    if ((int)ch1[0] > (int)ch1[1]) {
      temp = ch1[0];
      ch1[0] = ch1[1];
      ch1[1] = temp;
    }
    if ((int)ch1[0] > (int)ch1[2]) {
      temp = ch1[0];
      ch1[0] = ch1[2];
      ch1[2] = temp;
    }
    if ((int)ch1[1] > (int)ch1[2]) {
      temp = ch1[1];
      ch1[1] = ch1[2];
      ch1[2] = temp;
    }
    printf("%c %c %c\n", ch1[0], ch1[1], ch1[2]);
  }
  return 0;
}
/*
描述
输入三个字符（可以重复）后，按各字符的ASCII码从小到大的顺序输出这三个字符。
输入
第一行输入一个数N,表示有N组测试数据。后面的N行输入多组数据，每组输入数据都是占一行，有三个字符组成，之间无空格。
输出
对于每组输入数据，输出一行，字符中间用一个空格分开。
样例输入
2
qwe
asd
样例输出
e q w
a d s
*/