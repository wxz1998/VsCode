/*
@version 1.0
@author Wu Xianzhi
*/
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define I 20
#define R 340
int main() {
  int i, j, e;
  int a;
  for (i = 1, a = I; i < I / 2; i++, a--) {
    for (j = (int)(I - sqrt(I * I - (a - i) * (a - i))) + 1; j > 0; j--)
      printf(" ");
    for (e = 1; e <= 2 * sqrt(I * I - (a - i) * (a - i)); e++)
      printf("\3");
    for (j = (int)(2 * (I - sqrt(I * I - (a - i) * (a - i)))) + 1; j > 0; j--)
      printf(" ");
    for (e = 1; e <= 2 * sqrt(I * I - (a - i) * (a - i)); e++)
      printf("\3");
    printf("\n");
    Sleep(200);
  }
  for (i = 1; i < 80; i++) {
    if (i == 25) {
      printf("         Dear liu Yuwen!        ");
      i += 30;
    }
    printf("\3");
    Sleep(50);
  }
  printf("\n");

  for (i = 1; i <= R / 2; i++) {
    if (i % 2 || i % 3)
      continue;
    for (j = (int)(R - sqrt(R * R - i * i)); j > 0; j--)
      printf(" ");
    for (e = 0; e <= 2 * (sqrt(R * R - i * i) - (R - 2 * I)); e++)
      printf("\3");
    printf("\n");
    Sleep(100);
  }
  for (;;) {
    system("color a");
    Sleep(1000);
    system("color b");
    Sleep(1000);
    system("color c");
    Sleep(1000);
    system("color d");
    Sleep(1000);
    system("color e");
    Sleep(1000);
    system("color f");
    Sleep(1000);
    system("color 0");
    Sleep(1000);
    system("color 1");
    Sleep(1000);
    system("color 2");
    Sleep(1000);
    system("color 3");
    Sleep(1000);
    system("color 4");
    Sleep(1000);
    system("color 5");
    Sleep(1000);
    system("color 6");
    Sleep(1000);
    system("color 7");
    Sleep(1000);
    system("color 8");
    Sleep(1000);
    system("color 9");
    Sleep(1000);
    system("color ab");
    Sleep(1000);
    system("color ac");
    Sleep(1000);
    system("color ad");
    Sleep(1000);
    system("color ae");
    Sleep(1000);
    system("color af");
    Sleep(1000);
  }
  return 0;
}