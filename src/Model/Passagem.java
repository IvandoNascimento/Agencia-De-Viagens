package Model;

import Model.Exception.PassagemException;


public class Passagem extends Produto{

    protected int quantidade;
    protected Lugar destino;

    public Passagem( String nome,int quantidade,Lugar destino) {
        super(nome);
        this.quantidade = quantidade;
        this.destino =  destino;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public Lugar getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "quantidade=" + quantidade +
                ", destino=" + destino +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    @Override
    public double calculaPreco() {
        setPreco((getDestino().getPreco())*getQuantidade());
        return getPreco();
    }

    public void verificaPassagem() throws PassagemException {
        if (this.getQuantidade() <= 0 || this.getDestino() == null || this.getCodigo() < 0
                || this.getNome() == null ) {
            throw new PassagemException();
        }
    }
}


