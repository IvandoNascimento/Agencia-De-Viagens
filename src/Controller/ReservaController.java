package Controller;

import Model.Exception.PacoteException;
import Model.Lugar;

import Model.Pacote;
import Model.Passagem;
import Model.Repositorio.Repositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;


public class ReservaController implements Initializable {
    @FXML
    private TextField hospedagem;
    @FXML
    private DatePicker checkin;
    @FXML
    private DatePicker checkout;
    @FXML
    private ChoiceBox<String> lugar;
    @FXML
    private Button voltar;

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

    public void reservar() throws PacoteException {
        long dias = Duration.between(checkin.getValue().atStartOfDay(),checkout.getValue().atStartOfDay()).toDays();

        Passagem p = new Passagem("a",Integer.parseInt(
                hospedagem.getText()),Repositorio.lugares.procurar(lugar.getValue()));
        Pacote pacoteCliente = new Pacote(p.getNome(),p, (int) dias);
        System.out.println(pacoteCliente);
        Repositorio.pacotes.AdicionarPacote(pacoteCliente);

        AgenciaApplication.mudaTela("menu");

    }

    public void mudarTela(ActionEvent event){
        Button botao =(Button) event.getSource();
        AgenciaApplication.mudaTela(botao.getId());
    }


}
