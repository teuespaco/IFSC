import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws ParseException, IOException, InterruptedException {

        //hashMap();
        treeMap();
 }

public static void hashMap(){
    //Criaçãp do Hashmap
    Map<String,Pessoa> hashMap = new HashMap<String,Pessoa>();
    //Adição do Objeto pessoa atribuido a uma Key no formato String
    hashMap.put("Pessoa1",new Pessoa(20,"Alexandre","Justen"));
    hashMap.put("Pessoa2",new Pessoa(19,"Ruan","Binder"));
    hashMap.put("Pessoa3",new Pessoa(21,"Lucas","Matheus"));


    System.out.println("\n=========Hashmap =========");
    //toString herda do .AbstractMap
    System.out.println(hashMap);


    System.out.println("\ncapturando a Pessoa2: "+ hashMap.get("Pessoa2").getNome());


    System.out.println("\n=========Hashmap Foreach=========");
    for (Pessoa pessoa: hashMap.values()) {
        System.out.println(pessoa.getNome());
    }

    System.out.println("\n=========Hashmap Foreach Keys=========");
    for (String key : hashMap.keySet()) {
        System.out.println(String.format("key: %s", key));
    }
    System.out.println("\n=========Hashmap Foreach Keys e Values=========");
    //lambda posso estar enganado
    hashMap.forEach((k, v) -> System.out.println(String.format("key: %s | value: %s", k, v.getNome())));

    System.out.println("\nHashmap size: "+hashMap.size());

    System.out.println("\n=========Hashmap Remove=========");
    hashMap.remove("Pessoa1");

    System.out.println("\n=========Foreach apos Remove=========");
    for (Pessoa pessoa: hashMap.values()) {
        System.out.println(pessoa.getNome());
    }

    System.out.println("\n=========Hashmap Clear=========");
    hashMap.clear();

    hashMap.put("Pessoa4",new Pessoa(21,"Teste apos removido","removido"));
    hashMap.putIfAbsent("Pessoa4",new Pessoa(212,"Teste apos removido2","removido2"));

    System.out.println("\n=========Criação de novo Objeto e Foreach=========");
    for (Pessoa pessoa: hashMap.values()) {
        System.out.println(pessoa.getNome());
    }
}

public static void treeMap(){

    //Criaçãp do Treemap
    Map<String,Pessoa> treemap = new TreeMap<String,Pessoa>();
    //Adição do Objeto pessoa atribuido a uma Key no formato String
    treemap.put("Pessoa1",new Pessoa(20,"Alexandre","Justen"));
    treemap.put("Pessoa2",new Pessoa(19,"Ruan","Binder"));
    treemap.put("Pessoa3",new Pessoa(21,"Lucas","Matheus"));

    System.out.println("\n=========Treemap =========");
    //toString herda do .AbstractMap
    System.out.println(treemap);


    System.out.println("\ncapturando a Pessoa2: "+ treemap.get("Pessoa2").getNome());


    System.out.println("\n=========Treemap Foreach=========");
    for (Pessoa pessoa: treemap.values()) {
        System.out.println(pessoa.getNome());
    }

    System.out.println("\n=========Treemap Foreach Keys=========");
    for (String key : treemap.keySet()) {
        System.out.println(String.format("key: %s", key));
    }
    System.out.println("\n=========Treemap Foreach Keys e Values=========");

    treemap.forEach((k, v) -> System.out.println(String.format("key: %s | value: %s", k, v.getNome())));

    System.out.println("\nTreemap size: "+treemap.size());

    System.out.println("\n=========Treemap Remove=========");
    treemap.remove("Pessoa1");

    System.out.println("\n=========Foreach apos Remove=========");
    for (Pessoa pessoa: treemap.values()) {
        System.out.println(pessoa.getNome());
    }

    System.out.println("\n=========Treemap Clear=========");
    treemap.clear();

    treemap.put("Pessoa4",new Pessoa(21,"Teste apos removido","removido"));
    treemap.putIfAbsent("Pessoa4",new Pessoa(212,"Teste apos removido2","removido2"));

    System.out.println("\n=========Criação de novo Objeto e Foreach=========");
    for (Pessoa pessoa: treemap.values()) {
        System.out.println(pessoa.getNome());
    }


}

    }









