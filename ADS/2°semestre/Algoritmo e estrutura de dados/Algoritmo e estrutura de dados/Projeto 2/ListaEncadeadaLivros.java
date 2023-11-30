package ex2;

import java.util.Scanner;

public class ListaEncadeadaLivros {
	
	int numElementos;
	ElementoLivro primeiro;
	ElementoLivro ultimo;
	
	
	public ListaEncadeadaLivros() {
		numElementos = 0;
		primeiro = null;
		ultimo = null;
	}
	
	public void inserir(Livro livro) {
		
		ElementoLivro novoElementoLivro = new ElementoLivro();
		novoElementoLivro.livro = livro;
		novoElementoLivro.prox = null;
		
		if(numElementos == 0) {
			primeiro = novoElementoLivro;
			ultimo = novoElementoLivro;
			numElementos++;
			return;
		}
		
		ultimo.prox = novoElementoLivro;
		ultimo = novoElementoLivro;		
		numElementos++;
		return;
	}
	
	public void listar() {
		ElementoLivro aux = primeiro;
		
		for(int i=0; i<numElementos; i++) {
			System.out.println(
					"id: " + aux.livro.id
					+", titulo = " + aux.livro.titulo
					+", genero = " + aux.livro.genero
					+", ano = " + aux.livro.ano
					+", escritor: "+ aux.livro.escritor.nome);
			aux = aux.prox;
		}		

	}
	
	//editar livro

	
	public void editar(int id, Scanner input,ListaEncadeadaEscritores escritor) {
		ElementoLivro aux = primeiro;
		for(int i = 0; i<numElementos; i++) {
			if(aux.livro.id == id) {
				System.out.println("Que informação você quer editar"
						+" \n0 - Retornar ao menu "
						+" \n1 - Titulo "
						+" \n2 - Genero"
						+" \n3 - Ano"
						+" \n4 - Escritor");
				int opcao = Integer.valueOf(input.nextLine());
				switch(opcao) {
				case 0:
					return;
				case 1: 
					System.out.print("Digite o titulo do livro: ");
					String titulo = input.nextLine();
					aux.livro.titulo = titulo;
					System.out.println("Operação realizada com sucesso!");
					return;
				case 2: 
					System.out.print("Digite o genero do livro: ");
					String genero = input.nextLine();
					aux.livro.genero = genero;
					System.out.println("Operação realizada com sucesso!");
					return;
				case 3:
					System.out.print("Digite o ano de lançamento do livro: ");
					int ano = Integer.valueOf(input.nextLine());
					aux.livro.ano = ano;
					System.out.println("Operação realizada com sucesso!");
					return;				
				case 4:         
					System.out.print("Digite o id do escritor: ");	
					int idEscritor =  Integer.valueOf(input.nextLine());
					aux.livro.escritor = escritor.getEscritorId(idEscritor);
					System.out.println("Operação realizada com sucesso!");
					return;	
				}				
			}
		}
		System.out.println("Livro não encontrado,Operação cancelada!");	
	}
	
	//remover livro
	
	
	public void remover(int id) {
		ElementoLivro aux = primeiro;
		ElementoLivro antAux = null;
		
		for(int i=0; i<numElementos; i++) {
			
			if(aux.livro.id == id) {
				if(aux == primeiro) {
					primeiro = primeiro.prox;
					numElementos--;
					if(numElementos == 0) {
						ultimo = null;
					}
					return;					
				}
				antAux.prox = aux.prox;
				numElementos--;
				if(aux == ultimo) {
					ultimo = antAux;
				}
				return;
			}
			antAux = aux;
			aux = aux.prox;
		}
		System.out.println("Livro não encontrado,Operação cancelada!");	
		
		
	}
	
}
