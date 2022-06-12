package Controller;

import Model.Cliente;
import Model.Repositorio.Repositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button visualizar;

    @FXML
    private Button cadastrar;





    @FXML
    public void mudaTela(ActionEvent event) throws IOException {

        Button botao =(Button) event.getSource();

        AgenciaApplication.mudaTela(botao.getId());
    }
}