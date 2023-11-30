/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplolerarquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author aldir
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //criando um objeto User
        User user = new User(1, "Aldir", "Professor da unidade de Desenvolvimento de Sistemas");
        
        //Chamando o método escrever e passando user como parâmetro
//        escrever(user);
        ler();
    }
    
    private static void escrever(User user) {
        File dir = new File("C:\\Users\\aldir\\OneDrive\\Área de Trabalho");
        File arq = new File(dir, "User.txt");

        try {

            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(user.getId());
            printWriter.println(user.getNome());
            printWriter.println(user.getObservacao());

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private static void ler() throws FileNotFoundException, IOException {
        File dir = new File("C:\\Users\\aldir\\OneDrive\\Área de Trabalho");
        File arq = new File(dir, "User.txt");

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