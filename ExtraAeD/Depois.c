#include <stdio.h>

int temdivisor(int n){
  int c = 2;
  do{
    if(n % c == 0){
      return 1;
    }
    c++;
  }while(c<n);
  return 0;
}

int main()
{
  int n;
  scanf("%d", &n);
  if(temdivisor(n))
    return 1;
  return 0;
}
