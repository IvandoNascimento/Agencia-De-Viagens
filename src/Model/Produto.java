package Model;


//import Interfaces.IdentidadeI;
//import Interfaces.ItemI;


import Model.Interface.IdentidadeI;
import Model.Interface.ItemI;

public abstract class Produto implements Comparable, IdentidadeI, ItemI {

    protected int codigo;
    protected String nome;
    protected double preco;

    public Produto( String nome){
        this.nome = nome;
    }

    public Produto(String nome, int codigo, double preco){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double calculaPreco();

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
