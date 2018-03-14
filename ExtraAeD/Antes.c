#include <stdio.h>

int main()
{
  int n, p=1, c=2;
  printf("Digite um valor inteiro: ");
  scanf("%d", &n);
  do{
    if(n%c==0){
      p=0;
      printf("O numero %d e um divisor de %d.\n", c, n);
    }
    c++;
  }while(c<n);
  if(p==1)
    printf("O numero %d eh um numero primo.\n", n);
  else
    printf("O numero %d nao eh um numero primo.\n", n);
  return 0;
}
