package Model.Repositorio;

import Model.Exception.PassagemException;
import Model.Passagem;

import java.io.*;
import java.util.ArrayList;

public class PassagemRepositorio implements Serializable {

    public ArrayList<Passagem> PassagemRepositorio;
    protected int idPassagem;

    public PassagemRepositorio() {
        this.PassagemRepositorio = new ArrayList<>();
        this.idPassagem = 0;
    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public void AdicionarPassagem(Passagem passagem) throws PassagemException {
        passagem.setCodigo(idPassagem);
        passagem.verificaPassagem();
        this.PassagemRepositorio.add(passagem);
        idPassagem++;
    }

    public Passagem EncontrarId(int Id) {
        for (Passagem passagem : PassagemRepositorio) {
            if (passagem.getCodigo() == Id) {
                return passagem;
            }
        }
        return null;
    }

    public void Excluir(int Id) {
        for (Passagem passagem : PassagemRepositorio) {
            if (passagem.getCodigo() == Id) {
                PassagemRepositorio.remove(Id);
                System.out.println("Passagem removida com sucesso");
            } else {
                System.out.println("Passagem não cadastrada");
            }
        }
    }

    public void salvarRepositorio(String caminhoArquivo) throws IOException {
        FileOutputStream fout = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
    }

    public static PassagemRepositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        PassagemRepositorio resp = (PassagemRepositorio) ois.readObject();
        ois.close();
        return resp;
    }
}