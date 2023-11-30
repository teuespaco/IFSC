package exercicio1;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float c, l, p, resultado, total;
		Scanner s;
		
		s = new Scanner(System.in);	
		
		System.out.println("Comprimento: ");
		c = s.nextFloat();
		
		System.out.println("Largura: ");
		l = s.nextFloat();
		
		resultado = c * l;
		
		System.out.println("Preço: ");
		p = s.nextFloat();
		
		total = resultado * p;
		

		System.out.println("Total: " + total);
		
		
	}

}
