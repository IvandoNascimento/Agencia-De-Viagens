package Model;

import Model.Interface.IdentidadeI;

public class Cliente implements IdentidadeI {

    private final String nome;
    private final int idade;
    private final String telefone;

    public Cliente(String nome,int idade,String telefone){
        this.nome =  nome;
        this.idade = idade;
        this.telefone =  telefone;
    }


    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }
    @Override
    public String getNome() {
        return null;
    }

    @Override
    public void setNome(String nome) {

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
