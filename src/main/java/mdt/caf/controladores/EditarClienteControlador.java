package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class EditarClienteControlador {
    @FXML
    private TextField txtId;
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
    private Button btnValidar;
    @FXML
    private Button btnEditar;
    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            Metodos.validarCliente(btnValidar, txtId, btnEditar, txtNombre, txtApellidos, txtEdad, txtNumeroTelefono, txtCorreo);
        });
        btnEditar.setOnAction(e->{
            Metodos.editarCliente(txtNombre, txtApellidos, txtEdad, txtNumeroTelefono, txtCorreo);
        });
    }
}
