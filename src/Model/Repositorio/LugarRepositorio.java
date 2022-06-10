package Model.Repositorio;

import Model.Lugar;
import java.io.*;
import java.util.ArrayList;

public class LugarRepositorio implements Serializable {

    public ArrayList<Lugar> listaDeLugares;

    Lugar procurar(String nome){
        int nomeProcurado = -1;
        for (int i =0; i<listaDeLugares.toArray().length; i++) {
            if (listaDeLugares.get(i) != null && listaDeLugares.get(i).getNome().equals(nome)) {
                nomeProcurado = i;
                break;
            }
        }
        if(nomeProcurado != -1){
            return listaDeLugares.get(nomeProcurado);
        }
        return null;
    }

    public  void inserir(Lugar place){
        Lugar existe = procurar(place.getNome());
        if(existe != null){
            System.out.println("Não é possivel inserir, pois já existe uma instancia no repositorio");
        }else{
            listaDeLugares.add(place);
            System.out.println("A instancia foi inserida no repositorio");
        }
    }

    public void remover(String nome){
        Lugar encontrado = procurar(nome);
        if(encontrado != null){
            for (int i =0; i<listaDeLugares.toArray().length; i++){
                if(listaDeLugares.get(i) == encontrado){
                    listaDeLugares.remove(i);
                    System.out.println("o objeto foi removido");
                }
            }
        }else{
            System.out.println("o objeto não foi encontrado, logo nao pode ser removido");
        }
        for (int i = 0; i < listaDeLugares.toArray().length; i++) {
            System.out.println(listaDeLugares.get(i)+"\n");
        }
    }

    public void salvarRepositorio(String caminhoArquivo) throws IOException {
        FileOutputStream fout = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
    }

    public static LugarRepositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        LugarRepositorio resp = (LugarRepositorio) ois.readObject();
        ois.close();
        return resp;
    }
}

