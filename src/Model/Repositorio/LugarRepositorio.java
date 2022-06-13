package Model.Repositorio;

import Model.Lugar;
import java.io.*;
import java.util.ArrayList;

public class LugarRepositorio implements Serializable {

    public ArrayList<Lugar> listaDeLugares;

    public Lugar procurar(String nome){
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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Lugar SaoPaulo = new Lugar("Sao paulo",500);
        Lugar RioDeJaneiro= new Lugar("Rio de Janeiro",1000);
        Lugar Recife = new Lugar("Recife",350);
        Lugar PortoAlegre = new Lugar("Porto Alegre",1200);
        LugarRepositorio repositorio = new LugarRepositorio();
        repositorio.listaDeLugares = new ArrayList<>();
        repositorio.inserir(SaoPaulo);
        repositorio.inserir(RioDeJaneiro);
        repositorio.inserir(Recife);
        repositorio.inserir(PortoAlegre);
        String arquivoRepositorio = "./src/Model/Repositorio/repositorio.lugar";
        repositorio.salvarRepositorio(arquivoRepositorio);
        LugarRepositorio teste = LugarRepositorio.carregarRepositorio("./src/Model/Repositorio/repositorio.lugar");
        for (Lugar l: teste.listaDeLugares
        ) {
            System.out.println(l);

        }


    }
}

