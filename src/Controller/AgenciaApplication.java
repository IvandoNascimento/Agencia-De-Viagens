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

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        //scenes
        stage = primaryStage;
        Parent fxmlMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Menu.fxml")));
        menuScene = new Scene(fxmlMenu, 640, 400);
        Parent fxmlCadastro = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Cadastro.fxml")));
        cadastroScene = new Scene(fxmlCadastro,640,400);

        Repositorio.inicializar();


        stage.setTitle("Sweet Wanderlust");
        stage.setScene(menuScene);
        stage.show();
    }
    public static void mudaTela(String tela)  {
        switch (tela){
            case "cadastrar":
                stage.setScene(cadastroScene);
                break;
            case "menu":
                stage.setScene(menuScene);
                break;
            case "":
                break;
        }
    }

    public static void main(String[] args) {
        launch();

    }
}
