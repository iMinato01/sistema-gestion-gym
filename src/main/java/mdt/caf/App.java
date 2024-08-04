package mdt.caf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static mdt.caf.metodos.Metodos.stagePrincipal;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/inicio-sesion.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Control de Acceso");
        stage.setScene(scene);
        stage.setResizable(false);
        stagePrincipal = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}