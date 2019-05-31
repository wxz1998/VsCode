#include <stdio.h>
#include <string.h>
void dyj(int n)
{
	int i,j;
	for(i=1;i<=n;i++)
	{
		for(j=0;j<n-i;j++)
		printf(" ");
		for(j=0;j<2*i-1;j++)
		printf("*");
		printf("\n");
	}
}
int main(void)
{
	int n;
	printf("What planet number to print?\n");
	scanf("%d",&n);
	dyj(n);
	getchar();
	return 0;
}