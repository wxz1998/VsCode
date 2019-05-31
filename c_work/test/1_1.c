#include <stdio.h>
long isnarcissus(long a);
void narcissus();
int main(void)
{
	printf("你知道水仙花数么?不知道也没关系,告诉我你想打印多大数值内的水仙花数:");
	narcissus();
	getchar();
}

void narcissus()
{
	long i, b, c, d, e;
	scanf("%d", &e);
	for (i = 100; i <= e; i++)
		if (isnarcissus(i))
		{
			b = i / 100 % 10;
			c = i / 10 % 10;
			d = i % 10;
			printf("%d %d=%d*%d*%d+%d*%d*%d+%d*%d*%d\n", i, i, b, b, b, c, c, c, d, d, d);
		}
}

long isnarcissus(long a)
{
	long sum = 0, tmp;
	tmp = a;
	while (tmp > 0)
	{
		sum = sum + (tmp % 10) * (tmp % 10) * (tmp % 10);
		tmp = tmp / 10;
	}
	if (sum == a)
		return 1;
	else
		return 0;
}