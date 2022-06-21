package Controller;

import Model.*;
import Model.Repositorio.Repositorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaDeReservasController implements Initializable {
    @FXML
    private TableView<Produto> tabela;
    @FXML
    private TableColumn<Produto, String> nomeCol;
    @FXML
    private TableColumn<Produto, Integer> hospedeCol;
    @FXML
    private TableColumn<Produto, Lugar> lugarCol;
    @FXML
    private Button voltar;
    @FXML
    private Button reservar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        lugarCol.setCellValueFactory(
                new PropertyValueFactory<>("Lugar"));
        hospedeCol.setCellValueFactory(
                new PropertyValueFactory<>("hospedes"));

        tabela.setItems(listaDeReservas());
    }

    private ObservableList<Produto> listaDeReservas() {

        return FXCollections.observableArrayList(new Passagem("teste",1,new Lugar("teste",1))
        );
    }
    public void mudarTela(ActionEvent event){
        Button botao =(Button) event.getSource();
        AgenciaApplication.mudaTela(botao.getId());

    }


}
