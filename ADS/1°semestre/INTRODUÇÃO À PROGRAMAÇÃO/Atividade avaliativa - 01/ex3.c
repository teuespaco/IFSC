#include <stdio.h>
#include<math.h>

void main (){
    int ano,a,b,c;

    printf("Digite o ano de seu nascimento\n");
    scanf("%i",&ano);

    a=ano/100;
    b=ano%100;
    c=(a+b)%5;

    if (c==0) {
      printf("Seu ano de nascimento indica que voce e timido");
    }else
    if (c%5==1) {
      printf("Seu ano de nascimento indica que voce e sonhador");
    }else
    if (c%5==2) {
      printf("Seu ano de nascimento indica que voce e paquerador");
    }else
    if (c%5==3) {
      printf("Seu ano de nascimento indica que voce e atarente");
    }else
    if (c%5==4) {
      printf("Seu ano de nascimento indica que voce e irresistivel");
    }
}
