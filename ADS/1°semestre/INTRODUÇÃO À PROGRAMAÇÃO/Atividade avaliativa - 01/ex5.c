#include <stdio.h>

int main(int argc, char *argv[]) {
    int cs, cc;
    float p;

    printf("Qual o codigo do estado? ");
    scanf("%i", &cs);
    printf("Qual o peso do caminhao em toneladas? ");
    scanf("%f", &p);
    printf("Qual o codigo da carga? ");
    scanf("%i", &cc);

    p *= 1000;

    printf("O caminhao pesa %.2fkg\n", p);

    if ( cc < 21 ) {
        p *= 100;
    } else if ( cc < 31 ) {
        p *= 250;
    } else {
        p *= 340;
    }

    printf("A carga do caminhao custa R$%.2f\n", p);

    cc = (int) p;
    switch ( cs ) {
        case 1:
            p *= 0.35;
            break;
        case 2:
            p *= 0.25;
            break;
        case 3:
            p *= 0.15;
            break;
        case 4:
            p *= 0.05;
            break;
        case 5:
            p = 0;
            break;
    }
    printf("O imposto sobre carga do caminhao custa R$%.2f\n", p);
    printf("O custo total e de R$%.2f", p+cc);

    return 0;
}
