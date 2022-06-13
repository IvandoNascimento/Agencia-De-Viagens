package Controller;



import Model.Cliente;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;




public class CadastroController  {
    @FXML
    private Label nome;

    @FXML
    private TextField nomeCliente;

    @FXML
    private Label idade;

    @FXML
    private TextField idadeCliente;

    @FXML
    private Label telefone;

    @FXML
    private TextField numero;

    @FXML
    private Button cadastrar;


    public void Cadastrar(ActionEvent event) {
        //entradas
        String nomeDigitado = nomeCliente.getText();
        String idadeDigitada = idadeCliente.getText();
        String telefoneDigitado = numero.getText();
        String mensagem;
        //verifica se as entraadas sao validas

        if (valido(nomeDigitado)||!valido(idadeDigitada) || idadeDigitada.isBlank()|| !valido(telefoneDigitado)) {
            mensagem = "Por favor, preencha todos os campos corretamente";

            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro");
            dialogoInfo.setHeaderText(mensagem);
            dialogoInfo.setContentText("Um ou mais campos estao vazios ou invalidos");
            dialogoInfo.showAndWait();

        }
        else{
            Cliente cliente = new Cliente(nomeDigitado,Integer.parseInt(idadeDigitada),telefoneDigitado);
            mensagem = " Cliente cadastrado com sucesso ";

            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro ");
            dialogoInfo.setHeaderText(mensagem);
            dialogoInfo.setContentText("Cadastro realizado");
            dialogoInfo.showAndWait();

            Button botao = (Button) event.getSource();

            AgenciaApplication.mudaTela("menu");

            }
        }
    @FXML
    public void initialize() {

    }

    public  boolean valido(String a){
        return a.chars().allMatch(Character::isDigit);
    }


}
