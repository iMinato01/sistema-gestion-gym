package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class RegistrarClienteControlador {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtNumeroTelefono;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtClave;
    @FXML
    private Button btnRegistrar;
    @FXML
    public void initialize(){
        btnRegistrar.setOnAction(e->{
            Metodos.crearCliente(txtNombre, txtApellidos, txtEdad, txtNumeroTelefono, txtCorreo, txtClave);
        });
    }

}
