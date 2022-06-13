package Model.Repositorio;

import Model.*;

import java.io.IOException;
import java.util.ArrayList;

public class Repositorio {
    public static ArrayList<Cliente> clientes;
    public static LugarRepositorio lugares;
    public static PacoteRepositorio pacotes;
    public static PassagemRepositorio passagens;

    public static void inicializar() throws IOException, ClassNotFoundException {
        clientes = new ArrayList<>();
        lugares = LugarRepositorio.carregarRepositorio("./src/Model/Repositorio/repositorio.lugar");
        pacotes = new PacoteRepositorio();
        passagens = new PassagemRepositorio();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Repositorio.inicializar();
        //System.out.println(Repositorio.lugares.listaDeLugares.size());
        LugarRepositorio teste = LugarRepositorio.carregarRepositorio("./src/Model/Repositorio/repositorio.lugar");
        for (Lugar l: teste.listaDeLugares
             ) {
            System.out.println(l);

        }


    }

}
