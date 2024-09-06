package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class SuspenderClienteControlador {
    @FXML
    private Button btnValidar;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtMotivo;
    @FXML
    private TextField txtCorreo;
    @FXML
    Button btnSuspender;

    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            Metodos.validarCliente(txtId, btnValidar, txtCorreo, txtNombre, txtApellidos, txtEdad, txtTelefono, txtMotivo, btnSuspender);
        });
        btnSuspender.setOnAction(e->{
            Metodos.suspenderCliente();
        });
    }
}
