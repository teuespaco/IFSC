package ex2;

import java.util.Scanner;

public class ListaEncadeadaEscritores {
	
	int numElementos;
	ElementoEscritor primeiro;
	ElementoEscritor ultimo;
	
	public ListaEncadeadaEscritores() {
		numElementos = 0;
		primeiro = null;
		ultimo = null;
	}
	
	public void inserir(Escritor novoEscritor) {
		
		ElementoEscritor novoElementoEscritor = new ElementoEscritor();
		novoElementoEscritor.escritor = novoEscritor;
		novoElementoEscritor.prox = null;
		
		if(numElementos == 0) {
			primeiro = novoElementoEscritor;
			ultimo = novoElementoEscritor;
			numElementos++;
			return;
		}
		
		ultimo.prox = novoElementoEscritor;
		ultimo = novoElementoEscritor;		
		numElementos++;
		return;
	}

	public void listar() {
		ElementoEscritor aux = primeiro;
		
		for(int i=0; i<numElementos; i++) {
			System.out.println(
					"id: " + aux.escritor.id
					+", nome = " + aux.escritor.nome
					+", idade: "+ aux.escritor.idade);
			aux = aux.prox;
		}		

	}
	
	public Escritor getEscritor(int pos) {
		ElementoEscritor aux = primeiro;
		
		for(int i=0; i<numElementos; i++) {
			if (i==pos) {
				return aux.escritor;
			}
			aux = aux.prox;
		}
		System.out.println("Não encontrado!");
		return null;
	}
	
	public Escritor getEscritorId(int id) {
		ElementoEscritor aux = primeiro;
		
		for(int i=0; i<numElementos; i++) {
			if(aux.escritor.id == id) {
				return aux.escritor;
			}
			aux = aux.prox;
		}
		System.out.println("Não encontrado!");
		return null;
	}
	
	public void editar(int id, Scanner input) {
		ElementoEscritor aux = primeiro;
		for(int i = 0; i<numElementos; i++) {
			if(aux.escritor.id == id) {
				System.out.println("Que informação você quer editar"
						+" \n1 - Nome "
						+" \n2 - idade");
				int opcao = Integer.valueOf(input.nextLine());
				switch(opcao) {
				case 1: 
					System.out.print("Digite o nome do escritor: ");
					String nome = input.nextLine();
					aux.escritor.nome = nome;
					System.out.println("Operação realizada com sucesso!");
					return;
				case 2:
					System.out.print("Digite a idade do escritor: ");
					int idade = Integer.valueOf(input.nextLine());
					aux.escritor.idade = idade;
					System.out.println("Operação realizada com sucesso!");
					return;
				default:
					System.out.println("Operação invalida, Operação cancelada!");
					return;
				}				
			}
			aux = aux.prox;
		}
		System.out.println("Escritor não encontrado,Operação cancelada!");	
	}	
	
	public void remover(int id) {
		ElementoEscritor aux = primeiro;
		ElementoEscritor antAux = null;
		
		for(int i=0; i<numElementos; i++) {
			
			if(aux.escritor.id == id) {
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
		System.out.println("Escritor não encontrado,Operação cancelada!");		
	}
}
