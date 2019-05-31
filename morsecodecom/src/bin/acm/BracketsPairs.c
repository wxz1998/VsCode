
#include <stdio.h>
#include <string.h>
int main(void) {
  char s1[20001], s[20001];
  int N, a, i, j, len;
  scanf("%d", &N);
  while (N--) {
    j = 0;
    s1[0] = 0;
    scanf("%s", s);
    len = strlen(s);
    for (i = 0; i < len; i++) {
      a = s[i];
      if (a == s1[j] + 1 | a == s1[j] + 2) {
        s1[j] = 0;
        if (j != 0)
          j--;
      } else {
        if (s1[j] != 0)
          j++;
        s1[j] = a;
      }
    }
    if (s1[0] == 0)
      printf("Yes\n");
    else
      printf("No\n");
  }
  return 0;
}
/*
描述
现在，有一行括号序列，请你检查这行括号是否配对。
输入
第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，每组输入数据都是一个字符串S(S的长度小于10000，且S不是空串），测试数据组数少于5组。数据保证S中只含有"[",
"]", "(", ")" 四种字符 输出
每组输入数据的输出占一行，如果该字符串中所含的括号是配对的，则输出Yes,如果不配对则输出No
样例输入
3
[(])
(])
([[]()])
样例输出
No
No
Yes
*/