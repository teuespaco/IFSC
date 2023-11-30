package main;

public class Main {

	public static void main(String[] args) {
		
		Computador pc, notebook;
		pc = new Computador("Intel", 512);
		notebook = new Computador("AMD", 2048);
		System.out.print(" "+pc);		
		System.out.print(" "+notebook);		

		pc =null;
		notebook = null;
		System.out.println(""+pc);
		System.out.println(""+notebook);
		System.gc();


	}
}
