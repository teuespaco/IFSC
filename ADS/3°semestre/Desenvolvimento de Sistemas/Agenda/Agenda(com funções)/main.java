package agenda;
	/*
	 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
	 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
	 */

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

	/**
	 *
	 * @author aldir
	 */
	public class main {

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) throws IOException {
	        //criando um objeto User
	    	
	    	ArrayList<User> users = new ArrayList<User>();
	       	    	
	    	Scanner valor = new Scanner (System.in);
	    	
	    	User user = new User(1, "Aldir", "Professor da unidade de Desenvolvimento de Sistemas");
	        
	        //Chamando o método escrever e passando user como parâmetro
	    	escrever(users);
	        ler();
	        
	        int opcao = 1;
	        Scanner input = new Scanner (System.in);
	        while(opcao != 0) {

	        System.out.println("Digite para selecionar as opções"+
                    			"\n 0 - Para sair:"+
	                            "\n 1 - Para adicionar um usuário:"+
	                            "\n 2 - Para escrever no arquivo:"+
	                            "\n 3 - Para ler o arquivo:"
	                            );

	        

	        opcao = Integer.valueOf(input.nextLine());
	        switch (opcao) { 
	        case 0:
				break;	        
	        	case 1: 
	        		System.out.println("Digite o ID:");
	        		user.setId ( Integer.valueOf(input.nextLine()));
	        		System.out.println("Digite o nome:");
	        		user.setNome ( input.nextLine());
	        		System.out.println("Digite a observação:");
	        		user.setObservacao ( input.nextLine());
	        		users.add(user);
	        		break;
	        		
	            case 2:
	                escrever(users);
	                break;
	        
	            case 3:
	                ler();
	                break;
	                
	            default:
	                System.out.println("Opção inválida!");
	                break;
	        
	        }
	        }
	    }
	    
	    private static void escrever(ArrayList<User> users) {
	        File dir = new File("C:\\Users\\ACER\\Downloads\\Agenda");
	        File arq = new File(dir, "Teste.txt");

	        try {

	            arq.createNewFile();

	            FileWriter fileWriter = new FileWriter(arq, false);

	            PrintWriter printWriter = new PrintWriter(fileWriter);
	            
	            for(int i=0; i<users.size();i++) {
	            	printWriter.println(users.get(i).getId());
	            	printWriter.println(users.get(i).getNome());
	            	printWriter.println(users.get(i).getObservacao());
	            }

	            printWriter.flush();

	            printWriter.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	    
	    private static void ler() throws FileNotFoundException, IOException {
	        File dir = new File("C:\\Users\\ACER\\Downloads\\Agenda");
	        File arq = new File(dir, "Teste.txt");

	        try {
	            
	            FileReader fileReader = new FileReader(arq);

	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            
	            String linha = "";

	            while ((linha = bufferedReader.readLine()) != null) {
	                //Aqui imprimimos a linha
	                System.out.println(linha);
	            }

	        } catch (Exception e){
	            System.out.println(e);
	        }
	    }
	}
