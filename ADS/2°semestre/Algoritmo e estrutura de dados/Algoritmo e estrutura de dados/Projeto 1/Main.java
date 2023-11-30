package ex1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//DELIMITAR NUMERO MAXIMO DE ESCRITOR E LIVROS.
		int MAX_ESCRITOR = 30;
		int MAX_LIVRO = 50;
		
//Vetor de escritor
		Escritor escritor[] = new Escritor[MAX_ESCRITOR];
		int numeroEscritor = 0;
		
//Vetor de livros
		Livro livro[] = new Livro[MAX_LIVRO];
		int numeroLivro = 0;
		
//Escritores
		Escritor e;
//e-0
		e = new Escritor();
		e.id= 00;
		e.nome = "Vinicius Grossos";
		e.idade = 28;

		
		escritor[numeroEscritor] = e;
		numeroEscritor++;

//e-1
		e = new Escritor();
		e.id= 01;
		e.nome = "Jenifer Niven";
		e.idade = 53;
		
		escritor[numeroEscritor] = e;
		numeroEscritor++;
		
//e-2
		e = new Escritor();
		e.id= 02;
		e.nome = "Gayle Forman";
		e.idade = 51;
		
		escritor[numeroEscritor] = e;
		numeroEscritor++;


//Livros
		
		Livro l;
//l-0		
		
		l = new Livro();
		l.titulo = "O garoto quase atropelado";
		l.genero = "Romance";
		l.ano = 2015;
		l.escritor=escritor[0];
		
		livro[numeroLivro] = l;
		numeroLivro++;
		
//l-1
		l = new Livro();
		l.titulo = "Por lugares incriveis";
		l.genero = "Romance";
		l.ano = 2015;
		l.escritor=escritor[1];
		
		livro[numeroLivro] = l;
		numeroLivro++;
//l-2
		l = new Livro();
		l.titulo = "Eu perdi o rumo";
		l.genero = "Ficção";
		l.ano = 2018;
		l.escritor=escritor[2];
		
		livro[numeroLivro] = l;
		numeroLivro++;
		
//variaveis
		int menu=1;
		int editarescritor=0;
		int editarLivro=0;
		Scanner input = new Scanner(System.in);
		
		while (menu!=0) {
			
//marcador de cadastros
			
			System.out.println("▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣");
			int MarcadorEsc=0;
			int MarcadorLivro=0;
					for (int i = 0; i <= numeroEscritor ; i++) {
						
						MarcadorEsc = MAX_ESCRITOR - i;
					}
					for (int i = 0; i <= numeroLivro ; i++) {
						
						MarcadorLivro = MAX_LIVRO - i;
					}
					System.out.println("Cadastros Disponiveis para Escritores= "+MarcadorEsc);
					System.out.println("Cadastros Disponiveis para Livros= "+MarcadorLivro);
			System.out.println("----------------------------------------"
								+"\n\t\tMenu"
								+"\n\t\tDigite:"
								+"\n0 para sair"
								+"\n1 para cadastrar escritor"
								+"\n2 para cadastrar livro"
								+"\n3 para listar Escritores Cadastrados"
								+"\n4 para listar Livros Cadastrados  "
								+"\n5 Editar Escritores"
								+"\n6 Editar Livros"
								+"\n----------------------------------------");
			System.out.println("▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧▣▧▧");
			menu= Integer.valueOf(input.nextLine());
			if (menu<=7) {
				
			
			switch (menu) {
			case 0:
				break;

			case 1:
				Escritor novoEscritor = new Escritor();
				novoEscritor.id=numeroEscritor;
				System.out.print("Nome: ");
				novoEscritor.nome= input.nextLine();
				System.out.print("idade: ");
				novoEscritor.idade = Integer.valueOf(input.nextLine());
				escritor[numeroEscritor] = novoEscritor;
				numeroEscritor++;
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				break;
				
			case 2:
				Livro novolivro = new Livro();
				System.out.print("Titulo: ");
				novolivro.titulo = input.nextLine();
				System.out.print("Genero: ");
				novolivro.genero = input.nextLine();
				System.out.print("Ano de Lançamento: ");
				novolivro.ano = Integer.valueOf(input.nextLine());
				System.out.print("Nome do escritor: ");
				
				for (int i = 0; i < numeroEscritor; i++) {
					
					System.out.println(
							"id: " + escritor[i].id
							+"\tNome: "+ escritor[i].nome);
				}
				
				System.out.println("Digite o id do Escritor: ");
				int idEscritor = Integer.valueOf(input.nextLine());
				novolivro.escritor=escritor[idEscritor];
				
				livro[numeroLivro] = novolivro;
				numeroLivro++;
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				break;
				
			case 3:
				System.out.println("Escritor");
				for (int i = 0; i < numeroEscritor; i++) {
					
					System.out.println(
							"\nid = " + escritor[i].id
							+" \n|Nome = " + escritor[i].nome
							+" \n|idade = " + escritor[i].idade);
				}
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				break;
				
			case 4:
				System.out.println("\nLivro\n");
				for (int i = 0; i < numeroLivro; i++) {
					
					System.out.println(
							"\nTitulo = " + livro[i].titulo
							+" \n|Genero = " + livro[i].genero
							+" \n|Ano = " + livro[i].ano
							+" \n|Escritor = " + livro[i].escritor.nome);
				}
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				break;
				
			case 5:
				System.out.println("Editar Escritor\n");
				for (int i = 0; i < numeroEscritor; i++) {
					
					System.out.println(
							"id: " + escritor[i].id
							+"\tNome: "+ escritor[i].nome);
				}
				System.out.println("\nDigite o id do escritor");
				int editarEscritor= Integer.valueOf(input.nextLine());
				System.out.print("Nome: ");
				escritor[editarEscritor].nome= input.nextLine();
				System.out.print("Idade: ");
				escritor[editarEscritor].idade=  Integer.valueOf(input.nextLine());
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				break;
				
			case 6:
				System.out.println("Editar livro\n");
				for (int i = 0; i < numeroLivro; i++) {
					
					System.out.println(
							"id: " + escritor[i].id
							+"\ttitulo: "+ livro[i].titulo);
				}
				System.out.println("\nDigite o id do livro");
				int editarLIvro= Integer.valueOf(input.nextLine());
				System.out.print("Titulo: ");
				livro[editarLIvro].titulo= input.nextLine();
				System.out.print("genero: ");
				livro[editarLIvro].genero = input.nextLine();
				System.out.print("Ano de Lançamento: ");
				livro[editarLIvro].ano = Integer.valueOf(input.nextLine());
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				
					
				
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
				break;
			

			}
			
			}else{
				System.out.println("\nERRO: Digite um número valido");
				System.out.println("\nENTER para voltar ao menu: ");
				input.nextLine();
			}
		}
		
	}//Final da Função main

	
}