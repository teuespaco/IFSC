package exercicio1;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A, B, C, resultado;
		Scanner s;
		
		s = new Scanner(System.in);
		System.out.println("Digite o valor A: ");
		A = s.nextInt();
		
		System.out.println("Digite o valor de B: ");
		B = s.nextInt();
		
		System.out.println("Digite o valor de C: ");
		C = s.nextInt();
		
		A = A * A;
		B = B * B;
		C = C * C;
		
		resultado = A + B + C;
		
		
		System.out.println("O valor é: " + resultado);
		

	}

}
