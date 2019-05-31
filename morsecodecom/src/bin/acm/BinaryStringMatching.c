#include <stdio.h>
int main(void) {
  int N;
  scanf("%d", &N);
  getchar();
  char ch1[100];
  char ch2[100];
  while (N--) {
    scanf("%s", ch1);
    scanf("%s", ch2);
    printf("%s\n%s\n", ch1, ch2);
  }
  return 0;
}
/*
描述
Given two strings A and B, whose alphabet consist only ‘0’ and ‘1’. Your task is
only to tell how many times does A appear as a substring of B? For example, the
text string B is ‘1001110110’ while the pattern string A is ‘11’, you should
output 3, because the pattern A appeared at the posit 输入 The first line
consist only one integer N, indicates N cases follows. In each case, there are
two lines, the first line gives the string A, length (A) <= 10, and the second
line gives the string B, length (B) <= 1000. And it is guaranteed that B is
always longer than A. 输出 For each case, output a single line consist a single
integer, tells how many times do B appears as a substring of A. 样例输入
3
11
1001110110
101
110010010010001
1010
110100010101011
样例输出
3
0
3
*/