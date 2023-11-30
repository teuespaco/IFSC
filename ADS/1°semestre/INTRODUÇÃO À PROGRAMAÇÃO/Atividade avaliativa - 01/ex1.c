#include <stdio.h>
#include <stdlib.h>
int main(){
    float s,s1,s2,s3,st1,st2,st3;

    printf("Qual seu salario?");
    scanf("%f",&s);

    printf("Seu salario antes do reajuste e de: %.2f",s);

    if(s<500){
        printf("\nO percentual do seu aumento e de 15");
    }else
    if(s>=500&&s<=1000){
        printf("\nO percentual do seu aumento e de 10");
    }else
    if(s>1000){
        printf("\nO percentual do seu aumento e de 5");
    }

    s1= s*0.15;
    s2= s*0.10;
    s3= s*0.05;

    if(s<500){
        printf("\nO aumento no seu salario foi de: %.2f",s1);
    }else
    if(s>=500&&s<=1000){
        printf("\nO aumento no seu salario foi de: %.2f",s2);
    }else
    if(s>1000){
        printf("\nO aumento no seu salario foi de: %.2f",s3);
    }

    st1= s+s1;
    st2= s+s2;
    st3= s+s3;

    if(s<500){
        printf("\nSeu salario final e de: %.2f",st1);
      }else
      if(s>=500&&s<=1000){
        printf("\nSeu salario final e de: %.2f",st2);
      }else
      if(s>1000){
        printf("\nSeu salario final e de: %.2f",st3);
      }
}
