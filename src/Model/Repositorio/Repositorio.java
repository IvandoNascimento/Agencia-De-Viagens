package Model.Repositorio;

import Model.*;

import java.io.IOException;
import java.util.ArrayList;

public class Repositorio {
    public static ArrayList<Cliente> clientes;
    public static LugarRepositorio lugares;
    public static PassagemRepositorio pacotes;
    public static PassagemRepositorio passagens;

    public static void inicializar() throws IOException, ClassNotFoundException {
        clientes = new ArrayList<>();
        lugares = LugarRepositorio.carregarRepositorio("./src/Model/Repositorio/repositorio.lugar");


    }


}
