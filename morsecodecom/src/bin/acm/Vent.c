#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
int main(void) {
  int m, i, j, k, l, n, h;
  srand((unsigned)time(NULL));
  printf("你可以在这里发泄心中的不爽!\n疯狂的咒骂这个世界吧!");
  printf("首先,你想骂多久???稍微提示下,我们是按秒算的:\n");
  scanf("%d", &m);
  for (i = 0; i <= m; i++) {
    j = rand() % 10;
    h = rand() % 9;
    k = rand() % 5;
    l = rand() % 9;
    n = rand() % 6;
    switch (j) {
    case '0':
      printf("我 ");
      break;
    case '1':
      printf("特朗普 ");
      break;
    case '2':
      printf("奥巴马 ");
      break;
    case '3':
      printf("安倍晋三 ");
      break;
    case '4':
      printf("蔡英文 ");
      break;
    case '5':
      printf("马化腾 ");
      break;
    case '6':
      printf("马云 ");
      break;
    case '7':
      printf("王思聪 ");
      break;
    case '8':
      printf("我们院长 ");
      break;
    default:
      printf("我们王书记 ");
      break;
    }
    if (j == 0) {
      switch (k) {
      case '0':
        printf("疯狂地 ");
        break;
      case '1':
        printf("汗流浃背地 ");
        break;
      case '2':
        printf("卖力地 ");
        break;
      case '3':
        printf("死命地 ");
        break;
      default:
        printf("像疯子一样地 ");
      }
    } else {
      switch (l) {
      case '0':
        printf("疯狂地 ");
        break;
      case '1':
        printf("汗流浃背地 ");
        break;
      case '2':
        printf("卖力地 ");
        break;
      case '3':
        printf("死命地 ");
        break;
      case '4':
        printf("不要脸地 ");
        break;
      case '5':
        printf("像狗一样地 ");
        break;
      case '6':
        printf("像驴一样地 ");
        break;
      case '7':
        printf("被 ");
        break;
      default:
        printf("像疯子一样地 ");
      }
    }
    if (l == 7) {
      printf("zz\n");
    } else {
      switch (n) {
      case '0':
        printf("搞着 ");
        break;
      case '1':
        printf("捅着 ");
        break;
      case '2':
        printf("干着 ");
        break;
      case '3':
        printf("怼着 ");
        break;
      case '4':
        printf("操着 ");
        break;
      default:
        printf("啪着 ");
      }
    }
    switch (h) {
    case '0':
      printf("蔡英文!\n");
      break;
    case '1':
      printf("我们王书记!\n");
      break;
    case '2':
      printf("我们院长!\n");
      break;
    case '3':
      printf("马云!\n");
      break;
    case '4':
      printf("马化腾!\n");
      break;
    case '5':
      printf("王思聪!\n");
      break;
    case '6':
      printf("安倍晋三!\n");
      break;
    case '7':
      printf("奥巴马!\n");
      break;
    default:
      printf("特朗普!\n");
    }
    Sleep(1000);
  }
  return 0;
}
/*
我            疯狂地        啪着
特朗普        汗流浃背地      操着
奥巴马        卖力地        怼着
安倍晋三      不要脸地      干着
王思聪        像狗一样地    捅着
马化腾        死命地        搞着
马云          像驴一样地
马化腾的女儿    像疯子一样地
马云的女儿
我们院长        被        啪的/操的/怼的/干的/捅的/搞的
我们王书记                像狗/烂肉/烂泥/疯子一样 汗流浃背
蔡英文                        死命/疯狂/卖力/像狗一样/像驴一样地叫
*/