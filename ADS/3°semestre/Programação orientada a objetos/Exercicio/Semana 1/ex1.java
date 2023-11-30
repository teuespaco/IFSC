package exercicio1;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float km;
		float litros;
		Scanner s;
		
		s = new Scanner(System.in);	
		
		System.out.println("Quantidade de km: ");
		km = s.nextFloat();
		
		System.out.println("Quantidade de litros: ");
		litros = s.nextFloat();
		
		km = km / litros;
		
		System.out.println("Resultado: " + km);
		
		
	}

}
