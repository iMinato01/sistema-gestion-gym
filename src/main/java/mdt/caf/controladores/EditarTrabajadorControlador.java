package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class EditarTrabajadorControlador {
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
    private TextField txtHoraEntrada;
    @FXML
    private TextField txtHoraSalida;
    @FXML
    private TextField txtSalario;
    @FXML
    private TextField txtCorreo;
    @FXML
    Button btnEditar;

    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            Metodos.validarTrabajador(btnValidar, txtId, btnEditar, txtNombre, txtApellidos, txtEdad, txtTelefono, txtCurp, txtRfc,
                    txtNss, txtCategoria, txtHoraEntrada, txtHoraSalida, txtSalario, txtCorreo);
        });
        btnEditar.setOnAction(e->{
            Metodos.editarTrabajador(txtNombre, txtApellidos, txtEdad, txtTelefono, txtCurp, txtRfc,
                    txtNss, txtCategoria, txtSalario, txtCorreo);
        });
    }
}
