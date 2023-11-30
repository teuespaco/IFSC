package exercicio1;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a, p;
		Scanner s;
		
		s = new Scanner(System.in);
		System.out.println("Altura: ");
		a = s.nextFloat();
		
		System.out.println("Peso: ");
		p = s.nextFloat();
		
		a = p / ((float)Math.pow((double) a, (double) 2.0 ));
		
		System.out.println("Resultado: " + a);
		
		
		
	}

}
