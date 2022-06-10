package Model.Repositorio;

import Model.Exception.PacoteException;
import Model.Pacote;

import java.io.*;
import java.util.ArrayList;

public class PacoteRepositorio implements Serializable {

    public ArrayList<Pacote> PacoteRepositorio;
    protected int idPacote;

    public PacoteRepositorio(){
        this.PacoteRepositorio = new ArrayList<Pacote>();
        this.idPacote = 0;

    }

    public int getIdPacote() {
        return idPacote;
    }

    public void AdicionarPacote(Pacote pacote) throws PacoteException {
        pacote.setCodigo(idPacote);
        pacote.verificaPacote();
        this.PacoteRepositorio.add(pacote);
        idPacote++;
    }

    public Pacote EncontrarId(int Id){
        for (Pacote pacote: PacoteRepositorio) {
            if(pacote.getCodigo() == Id){
                return pacote;
            }
        }
        return null;

    }public void Excluir (int Id){
        Pacote pacoteEncontrado =EncontrarId(Id);
        if (pacoteEncontrado != null){
            PacoteRepositorio.remove(pacoteEncontrado);
            System.out.println("Pacote removido com sucesso");
        }else{
            System.out.println("Pacote não cadastrado");
        }

    }

    public void salvarRepositorio(String caminhoArquivo) throws IOException {
        FileOutputStream fout = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
    }

    public static PacoteRepositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        PacoteRepositorio resp = (PacoteRepositorio) ois.readObject();
        ois.close();
        return resp;
    }
}