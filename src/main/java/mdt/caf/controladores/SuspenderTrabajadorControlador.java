package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class SuspenderTrabajadorControlador {
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
    private TextField txtCurp;
    @FXML
    private TextField txtRfc;
    @FXML
    private TextField txtNss;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtMotivo;
    @FXML
    private TextField txtCorreo;
    @FXML
    Button btnSuspender;

    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            Metodos.validarTrabajador(txtId, btnValidar, txtCorreo, txtNombre, txtApellidos, txtEdad, txtTelefono, txtCurp,
                    txtRfc, txtNss, txtCategoria, txtMotivo, btnSuspender);
        });
        btnSuspender.setOnAction(e->{
            Metodos.suspenderTrabajador();
        });
    }
}
