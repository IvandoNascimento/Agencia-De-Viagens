package Model;


import Model.Exception.PacoteException;

public class Pacote extends Produto{

    protected Passagem passagem;
    protected int dias;

    public Pacote( String nome, Passagem passagem, int dias) {
        super(nome);
        this.passagem = passagem;
        this.dias = dias;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    @Override
    public double calculaPreco() {
        double hospedagem = getDias()*100;
        double totalPassagem = getPassagem().getPreco();
        setPreco(totalPassagem+hospedagem);
        return getPreco();
    }
    public Passagem getPassagem() {
        return passagem;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public void verificaPacote() throws PacoteException {
        if(this.getPassagem() == null || this.getDias() <= 0 || this.getCodigo() < 0 || this.getNome() == null){
            throw new PacoteException();
        }
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "passagem=" + passagem +
                ", dias=" + dias +
                "} ";
    }
}

