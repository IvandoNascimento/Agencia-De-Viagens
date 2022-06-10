package Model;



import java.io.Serializable;
import java.util.*;

public class Lugar  implements Serializable {

    protected String nome;
    protected int preco;
    protected int dias;


    public Lugar(String name, int preco, int dias){
        this.nome = name;
        this.preco = preco;
        this.dias = dias;

    }
    public Lugar(String name, int preco){
        this.nome = name;
        this.preco = preco;
        this.dias = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public int getDias() {
        return dias;
    }

    public boolean comparison(Lugar b){
        return Objects.equals(this.nome, b.nome);
    }
    @Override
    public String toString() {
        return "Lugar{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", dias=" + dias +
                '}';
    }

}


