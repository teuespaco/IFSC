import java.util.Calendar;
import java.util.GregorianCalendar;


public class Pessoa {
    private int idade;
    private String nome;
    private String sobreNome;


    public Pessoa(int idade, String nome, String sobreNome) {
        this.idade = idade;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
