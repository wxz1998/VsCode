
#include <stdio.h>

int main(void) {
  int N, K;
  do {
    scanf("%d %d", &N, &K);
  } while ((N < 6 || N > 10) && (K < 1 || K > 6));
}