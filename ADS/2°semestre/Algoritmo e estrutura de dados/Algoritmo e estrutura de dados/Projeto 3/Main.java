package ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		List<Escritor> listaEscritores = new LinkedList<Escritor>();
		List<Livro> listaLivros = new LinkedList<Livro>();
		
		
		int idEscritores = iniciaListaEscritores(listaEscritores);
		int idLivros = iniciaListaLivros(listaLivros, listaEscritores);
		
		Escritor e;
		Livro l;
		int idEscritor=-1;
		int idLivro=-1;
		int opcao2 = -1;
		
		int opcao = 1;
		Scanner input = new Scanner(System.in);
		
		while(opcao != 0) {
			System.out.println("Digite:"
					+ "\n0 para sair"
					+ "\n1 para cadastrar novo Escritor"
					+ "\n2 para listar todos os escritores cadastrados"
					+ "\n3 para cadastrar novo Livro"
					+ "\n4 para listar todos os livros cadastrados"
					+ "\n5 para editar um Escritor"
					+ "\n6 para editar um Livro"
					+ "\n7 para remover um Escritor"
					+ "\n8 para remover um Livro");
			
			opcao = Integer.valueOf(input.nextLine());
			switch(opcao) {
			case 0:
				break;
			case 1:
				e = new Escritor();
				e.id = idEscritores;
				idEscritores++;
				System.out.print("Digite o nome do escritor ");
				e.nome = input.nextLine();
				System.out.print("Digite a idade do escritor: ");
				e.idade = Integer.valueOf(input.nextLine());
				listaEscritores.add(e);
				System.out.println("Operação realizada com sucesso!\n\n");
				break;
				
			case 2:
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					System.out.println(
							"id: " + e.id
							+"\tnome: "+e.nome
							+"\tidade: "+e.idade);
				}
				System.out.println("\n");
				break;
			case 3:
				l = new Livro();
				l.id = idLivros;
				idLivros++;
				System.out.print("Digite o titulo do livro: ");
				l.titulo = input.nextLine();
				System.out.print("Digite o genero do livro: ");
				l.genero = input.nextLine();
				System.out.print("Digite o ano de lancamento do livro: ");
				l.ano = Integer.valueOf(input.nextLine());
				
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					System.out.println(
							"id: " + e.id
							+"\tnome: "+e.nome);
				}
				
				System.out.print("Digite o id do escritor: ");
				idEscritor = Integer.valueOf(input.nextLine());
				
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					if(idEscritor == e.id) {
						l.escritor = e;
						break;
					}
				}
				if(l.escritor == null) {
					System.out.println("Escritor não encontrado! Operação cancelada!\n\n");
					idLivros--;
				}else {
					listaLivros.add(l);
					System.out.println("Operação realizada com sucesso!\n\n");
				}
				break;
				
			case 4:
				for(int i = 0; i<listaLivros.size(); i++) {
					l = listaLivros.get(i);
					System.out.println(
							"id: " + l.id
							+"\tnome: "+l.titulo
							+"\tgenero: "+l.genero
							+"\tano de lancamento: "+l.ano
							+"\tescritor: "+l.escritor.nome);
				}
				System.out.println("\n");
				break;
				
			case 5:
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					System.out.println(
							"id: " + e.id
							+"\tnome: "+e.nome);
				}
				System.out.println("Digite o id do escritor que deseja editar: ");
				idEscritor = Integer.valueOf(input.nextLine());
				
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					if(idEscritor == e.id) {
						System.out.println("Qual informacao voce deseja editar: "
								+ "\n1 - nome"
								+ "\n2 - idade");
						opcao2 = Integer.valueOf(input.nextLine());
						switch(opcao2) {
							case 1:
								System.out.print("Digite o nome do escritor: ");
								e.nome = input.nextLine();
								System.out.println("Operação realizada com sucesso!\n\n");
								break;
							case 2: 
								System.out.print("Digite a idade do escritor: ");
								e.idade = Integer.valueOf(input.nextLine());
								System.out.println("Operação realizada com sucesso!\n\n");
								break;
							default:
								System.out.println("Operação invalida, Operação cancelada!\n\n");
						}
					}
				}
				break;
				
			case 6:
				for(int i = 0; i<listaLivros.size(); i++) {
					l = listaLivros.get(i);
					System.out.println(
							"id: " + l.id
							+"\tnome: "+l.titulo
							+"\tescritor: "+l.escritor.nome);
				}
				
				System.out.println("Digite o id do livro que deseja editar: ");
				idLivro = Integer.valueOf(input.nextLine());
				
				for(int i = 0; i<listaLivros.size(); i++) {
					l = listaLivros.get(i);
					if(l.id == idLivro) {
						System.out.println("Qual informacao voce deseja editar: "
								+ "\n1 - titulo"
								+ "\n2 - Escritor");			
						
						opcao2 = Integer.valueOf(input.nextLine());
						switch(opcao2) {
						case 1:
							System.out.print("Digite o titulo do livro: ");
							l.titulo = input.nextLine();
							System.out.println("Operação realizada com sucesso!\n\n");
							break;
						case 2:
							for(int j = 0; j<listaEscritores.size(); j++) {
								e = listaEscritores.get(j);
								System.out.println(
										"id: " + e.id
										+"\tnome: "+e.nome);
							}
							System.out.println("Digite o id do escritor do livro: ");
							idEscritor = Integer.valueOf(input.nextLine());
							for(int j = 0; j<listaEscritores.size(); j++) {
								e = listaEscritores.get(j);
								if(e.id == idEscritor) {
									l.escritor = e;
									System.out.println("Operação realizada com sucesso!\n\n");
									break;
								}
								if(j == listaEscritores.size()-1) {
									System.out.println("Escritor não encontrado! Operação cancelada!\n\n");
									break;
								}
							}
							break;
						default:
							System.out.println("Operação invalida, Operação cancelada!");
						}
						if(i==listaLivros.size()-1) {
							System.out.println("Livro não encontrado! Operação cancelada!\n\n");
						}
					}
				}
				break;
			case 7:
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					System.out.println(
							"id: " + e.id
							+"\tnome: "+e.nome);
				}
				System.out.println("Digite o id do diretor que deseja remover: ");
				idEscritor = Integer.valueOf(input.nextLine());
				for(int i = 0; i<listaEscritores.size(); i++) {
					e = listaEscritores.get(i);
					if(e.id == idEscritor) {
						listaEscritores.remove(i);
						System.out.println("Operação realizada com sucesso!\n\n");
						break;
					}
					if(i== listaEscritores.size()-1) {
						System.out.println("Escritor não encontrado! Operação cancelada!\n\n");
					}
				}
				break;
				
			case 8:
				for(int i = 0; i<listaLivros.size(); i++) {
					l = listaLivros.get(i);
					System.out.println(
							"id: " + l.id
							+"\tnome: "+l.titulo
							+"\tescritor: "+l.escritor.nome);
				}
				
				System.out.println("Digite o id do livro que deseja remover: ");
				idLivro = Integer.valueOf(input.nextLine());
				
				for(int i = 0; i<listaLivros.size(); i++) {
					l = listaLivros.get(i);
					if(l.id == idLivro) {
						listaLivros.remove(i);
						System.out.println("Operação realizada com sucesso!\n\n");
						break;
					}
					if(i== listaLivros.size()-1) {
						System.out.println("Livro não encontrado! Operação cancelada!\n\n");
					}
				}
				
				break;
			default:
				System.out.println("Operação invalida, Operação cancelada!\n\n");
				break;
			}
			
		}
		
		input.close();	
		
	}
	
	public static int iniciaListaLivros(List<Livro> listaLivros, List<Escritor> listaEscritores) {
		
		int idLivros = 0;
		
		Livro l = new Livro();
		l.id = idLivros;
		l.titulo = "O garoto quase atropelado";
		l.genero = "Romance";
		l.ano = 2015;
		l.escritor = listaEscritores.get(0);	
	
		listaLivros.add(l);
		idLivros++;

		l = new Livro();
		l.id = idLivros;
		l.titulo = "Por lugares incriveis";
		l.genero = "Romance";
		l.ano = 2015;
		l.escritor = listaEscritores.get(1);			
		
		listaLivros.add(l);
		idLivros++;
		
		l = new Livro();
		l.id = idLivros;
		l.titulo = "Eu perdi o rumo";
		l.genero = "Ficção";
		l.ano = 2018;
		l.escritor = listaEscritores.get(2);			
		
		listaLivros.add(l);
		idLivros++;
		
		return idLivros;
		
	}

	public static int iniciaListaEscritores(List<Escritor> listaEscritores) {

		Escritor e;
		int idEscritores = 0;
		
		e = new Escritor();
		e.id = idEscritores;
		e.nome = "Vinicius Grossos";
		e.idade = 28;
		
		listaEscritores.add(e);
		idEscritores++;
		
		e = new Escritor();
		e.id = idEscritores;
		e.nome = "Jenifer Niven";
		e.idade = 53;
		
		listaEscritores.add(e);
		idEscritores++;
	
		e = new Escritor();
		e.id = idEscritores;
		e.nome = "Gayle Forman";
		e.idade = 51;
		
		listaEscritores.add(e);
		idEscritores++;
		
		
		return idEscritores;
		
	}

}
