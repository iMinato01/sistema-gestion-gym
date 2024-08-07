package mdt.caf.metodos;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mdt.caf.objetos.Producto;

import java.io.IOException;

import static mdt.caf.metodos.Metodos.referenciaStage;

public class Configuradores {
    public static <T> void ajustarColumna(TableView<T> tabla){
        tabla.getColumns().forEach(elemento -> {
            elemento.setReorderable(false);
        });
    }

    public static void ajustarFiltro(ComboBox<String> combobox, String elemento1, String elemento2){
        combobox.setItems(FXCollections.observableArrayList(elemento1, elemento2));
        combobox.getSelectionModel().select(0);
    }

    public static void ajustarBoton(Button boton, String rutaIcono, String tooltip){
            boton.setTooltip(new Tooltip(tooltip));
            Image icono = new Image(Configuradores.class.getResourceAsStream(rutaIcono));
            boton.setGraphic(new ImageView(icono));
    }

    public static void abrirVentana(Button boton, String rutaVentana, String tituloVentana){
        boton.setOnAction(event-> {
            try {
                if(referenciaStage != null){
                    referenciaStage.close();
                }
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(Configuradores.class.getResource(rutaVentana));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle(tituloVentana);
                stage.setResizable(false);
                referenciaStage = stage;
                stage.show();
            } catch (IOException e){
                Mensaje.error("Ocurrió un error al intentar abrir la ventana\n Error: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    public static void abrirVentana(String rutaVentana, String tituloVentana){
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(Configuradores.class.getResource(rutaVentana));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle(tituloVentana);
                if(referenciaStage == null){
                    referenciaStage = stage;
                }
                else{
                    referenciaStage.close();
                }
                stage.show();
            } catch (IOException e){
                Mensaje.error("Ocurrió un error al intentar abrir la ventana\n Error: " + e.getMessage());
                e.printStackTrace();
            }
    }
}
