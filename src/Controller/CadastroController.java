package Controller;

import Model.Cliente;

import Model.Repositorio.Repositorio;
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
    @FXML
    private Button voltar;

    public void cadastrar() {
        //entradas
        String nomeDigitado = nomeCliente.getText();
        String idadeDigitada = idadeCliente.getText();
        String telefoneDigitado = numero.getText();
        String mensagemCabecalho;
        String mensagemConteudo;
        //verifica se as entraadas sao validas

        if (!valido(nomeDigitado)||valido(idadeDigitada) || idadeDigitada.isBlank()  || Integer.parseInt(idadeDigitada) > 100 || valido(telefoneDigitado)) {
            mensagemCabecalho = "Por favor, preencha todos os campos corretamente";
            mensagemConteudo = "Um ou mais campos estao vazios ou sao invalidos";
        }
        else{
            Cliente cliente = new Cliente(nomeDigitado,Integer.parseInt(idadeDigitada),telefoneDigitado);
            mensagemCabecalho = " Cliente cadastrado com sucesso ";
            mensagemConteudo =  "Cliente inserido no sistema";


            Repositorio.clientes.add(cliente);
            AgenciaApplication.mudaTela("menu");

            }
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Cadastro");
        dialogoInfo.setHeaderText(mensagemCabecalho);
        dialogoInfo.setContentText(mensagemConteudo);
        dialogoInfo.showAndWait();
        }

    public void mudarTela(ActionEvent event){
        Button botao =(Button) event.getSource();
        AgenciaApplication.mudaTela(botao.getId());

    }

    public  boolean valido(String a){
        return a.chars().allMatch(Character::isAlphabetic);
    }


}
