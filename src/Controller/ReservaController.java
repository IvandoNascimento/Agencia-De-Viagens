package Controller;

import Model.Exception.PacoteException;
import Model.Lugar;

import Model.Pacote;
import Model.Passagem;
import Model.Repositorio.Repositorio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ReservaController implements Initializable {

    @FXML
    private TextField hospedagem;

    @FXML
    private TextField dias;

    @FXML
    private ChoiceBox<String> lugar;

    @FXML
    private Button comprar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Repositorio.inicializar();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Lugar t: Repositorio.lugares.listaDeLugares
        ) {
            lugar.getItems().add(t.getNome());
        }
    }
    @FXML
    public void comprar() throws PacoteException {

        String hospedesQtd = hospedagem.getText();
        String diasQtd = dias.getText();
        String lugarEscolhido = lugar.getValue();

        Passagem p = new Passagem("a",Integer.parseInt(
                hospedagem.getText()),Repositorio.lugares.procurar(lugar.getValue()));
        Pacote pacoteCliente = new Pacote(p.getNome(),p,Integer.parseInt(dias.getText()));
        System.out.println(pacoteCliente);
        Repositorio.pacotes.AdicionarPacote(pacoteCliente);


        System.out.println("teste");


        AgenciaApplication.mudaTela("menu");
    }


}
