package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class RegistrarProductoControlador {
    @FXML
    private TextField txtClave;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtUnidad;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button btnRegistrar;
    @FXML
    public void initialize(){
        btnRegistrar.setOnAction(e->{
            Metodos.crearProducto(txtClave, txtNombre, txtUnidad, txtPrecio);
        });
    }
}
