package exercicio1;

import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c, j, resultado;
		int mes;
		Scanner s;
		
		s = new Scanner(System.in);
		System.out.println("Digite o capital: ");
		c = s.nextFloat();
		
		System.out.println("Digite a taxa de juros: ");
		j = s.nextFloat();
		
		System.out.println("Digite a quantidade de meses: ");
		mes = s.nextInt();
		
		resultado = c * (Math.pow((1 + j / 100), mes));
		
		System.out.println("Montante:\n".format("%.2f", resultado));
		
		
	}

}
