package exercicio1;

import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float t, v, resultado;
		Scanner s;
		
		s = new Scanner(System.in);
		System.out.println("Tamanho do arquivo: ");
		t = s.nextFloat();
		
		System.out.println("Velocidade da conexão: ");
		v = s.nextFloat();
		
		resultado = t / v;
		
		System.out.println("Tempo necessário para download do arquivo:\n" + resultado);
		
		
		
		
		
		
	}

}
