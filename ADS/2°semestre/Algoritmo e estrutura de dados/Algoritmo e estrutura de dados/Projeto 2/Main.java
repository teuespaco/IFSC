package ex2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ListaEncadeadaEscritores listaEscritores = new ListaEncadeadaEscritores();
		ListaEncadeadaLivros listaLivros = new ListaEncadeadaLivros();
		

		iniciarListaEscritores(listaEscritores);
		iniciarListaLivros(listaLivros, listaEscritores);
		
		int idEscritores = 3;
		int idLivros = 3;
		
		int opcao = 1;
		Scanner input = new Scanner(System.in);
		
		while(opcao != 0) {
			System.out.println("Digite:"
					+ "\n0 para sair"
					+ "\n1 para cadastrar novo Escritor"
					+ "\n2 para listar todos os escritores cadastrados"
					+ "\n3 para editar um Escritor"
					+ "\n4 para remover um Escritor"
					+ "\n5 para cadastrar novo Livro"
					+ "\n6 para listar todos os Livro cadastrados"
					+ "\n7 para editar um Livro"
					+ "\n8 para remover um Livro");
			
			int idEscritor;
			opcao = Integer.valueOf(input.nextLine());
			switch(opcao) {
			case 0:
				return;
			case 1:
				Escritor novoEscritor = new Escritor();
				novoEscritor.id = idEscritores;
				System.out.print("Digite o nome do Escritor: ");
				novoEscritor.nome = input.nextLine();
				System.out.print("Digite a idade do escritor: ");
				novoEscritor.idade = Integer.valueOf(input.nextLine());
				listaEscritores.inserir(novoEscritor);
				idEscritores++;			
			break;
			case 2:
				listaEscritores.listar();
				break;
			case 3:
				System.out.println("Digite o id do escritor que deseja editar: ");
				idEscritor = Integer.valueOf(input.nextLine());
				listaEscritores.editar(idEscritor, input);
				break;
			case 4:
				System.out.println("Digite o id do escritor que deseja remover: ");
				idEscritor = Integer.valueOf(input.nextLine());
				listaEscritores.remover(idEscritor);
				break;
			case 5:
				Livro novoLivro = new Livro();
				novoLivro.id = idLivros;
				System.out.print("Digite o titulo do livro: ");
				novoLivro.titulo = input.nextLine();
				System.out.print("Digite a Genero do Livro: ");
				novoLivro.genero = input.nextLine();
				System.out.print("Digite o ano de lançamento livro: ");
				novoLivro.ano = Integer.valueOf(input.nextLine());
				System.out.print("Digite o id do Esctitor:\n ");
				
				ElementoEscritor aux = listaEscritores.primeiro;
				for(int i =0; i<listaEscritores.numElementos; i++) {
					System.out.println("id = "
							+aux.escritor.id
							+" nome = "
							+aux.escritor.nome);
					aux = aux.prox;
				}
				
				idEscritor = Integer.valueOf(input.nextLine());
				Escritor e = listaEscritores.getEscritorId(idEscritor);
				if (e == null) {
					System.out.println("Operação cancelada!");
				}else {
					novoLivro.escritor = e;
					listaLivros.inserir(novoLivro);
					idLivros++;
				}
				break;
			case 6:
				listaLivros.listar();
				break;
			case 7:
				System.out.println("Digite o id do livro que deseja editar: ");
				idLivros = Integer.valueOf(input.nextLine());
				listaLivros.editar(idLivros, input, listaEscritores);				
				break;
			case 8:
				System.out.println("Digite o id do livro que deseja remover: ");
				idLivros = Integer.valueOf(input.nextLine());
				listaLivros.remover(idLivros);
				break;
			default:
				System.out.println("Operação invalida!");
			}
			
		}
	}


	public static void iniciarListaLivros(ListaEncadeadaLivros listaLivros, ListaEncadeadaEscritores listaEscritores) {
	
		int idLivros = 0;
		Livro l = new Livro();
		l.titulo = "O garoto quase atropelado";
		l.genero = "Romance";
		l.ano = 2015;
		l.escritor = listaEscritores.getEscritor(0);		
		
		listaLivros.inserir(l);
		idLivros++;
		
		l = new Livro();
		l.id = idLivros;
		l.titulo = "Por lugares incriveis";
		l.genero = "Romance";
		l.ano = 2015;
		l.escritor = listaEscritores.getEscritor(1);			
		
		listaLivros.inserir(l);
		idLivros++;
		
		l = new Livro();
		l.id = idLivros;
		l.titulo = "Eu perdi o rumo";
		l.genero = "Ficção";
		l.ano = 2018;
		l.escritor = listaEscritores.getEscritor(2);			
		
		listaLivros.inserir(l);
		idLivros++;
		
		
	}

	
	public static void iniciarListaEscritores(ListaEncadeadaEscritores listaEscritores) {
		
		int idEscritores = 0;
		
		Escritor e = new Escritor();
		e.id = idEscritores;
		e.nome = "Vinicius Grossos";
		e.idade = 28;
		
		listaEscritores.inserir(e);
		idEscritores++;
		
		e = new Escritor();
		e.id = idEscritores;
		e.nome = "Jenifer Niven";
		e.idade = 53;
		
		listaEscritores.inserir(e);
		idEscritores++;
		
		e = new Escritor();
		e.id = idEscritores;
		e.nome = "Gayle Forman";
		e.idade = 51;
		
		listaEscritores.inserir(e);
		idEscritores++;
		
	}
}
