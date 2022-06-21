package Controller;


import Model.Repositorio.Repositorio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class AgenciaApplication extends Application {
    private static Stage stage;
    private static Scene menuScene;
    private static Scene cadastroScene;
    private static Scene reservaScene;
    private static Scene listaDeReservasScene;

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        //scenes
        stage = primaryStage;
        Parent fxmlMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Menu.fxml")));
        menuScene = new Scene(fxmlMenu, 640, 400);
        Parent fxmlCadastro = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Cadastro.fxml")));
        cadastroScene = new Scene(fxmlCadastro,640,400);
        Parent fxmlReserva = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Reserva.fxml")));
        reservaScene = new Scene(fxmlReserva,640,400);
        Parent fxmlListaDeReserva = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/ListaDeReservas.fxml")));
        listaDeReservasScene = new Scene(fxmlListaDeReserva,640,400);

        Repositorio.inicializar();

        stage.setTitle("Sweet Wanderlust");
        stage.setScene(menuScene);
        stage.show();
    }
    public static void mudaTela(String tela)  {
        switch (tela) {
            case "cadastrar" -> stage.setScene(cadastroScene);
            case "menu", "voltar" -> stage.setScene(menuScene);
            case "reservar" -> stage.setScene(reservaScene);
            case "visualizar" -> stage.setScene(listaDeReservasScene);
        }
    }

    public static void main(String[] args) {
        launch();

    }
}
