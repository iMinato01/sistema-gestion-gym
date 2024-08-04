package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static mdt.caf.metodos.Metodos.crearTrabajador;
import static mdt.caf.metodos.Metodos.referenciaStage;


public class RegistrarTrabajadorControlador {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtNumeroTelefono;
    @FXML
    private TextField txtCurp;
    @FXML
    private TextField txtNss;
    @FXML
    private TextField txtRfc;
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
    private TextField txtClave;
    @FXML
    private Button btnRegistrar;
    public void initialize(){
        btnRegistrar.setOnAction(e ->{
            if(crearTrabajador(txtNombre, txtApellidos, txtEdad, txtNumeroTelefono, txtCurp, txtRfc,
                    txtNss, txtCategoria, txtHoraEntrada, txtHoraSalida, txtSalario, txtCorreo, txtClave)){
                if(referenciaStage != null) {
                    referenciaStage.close();
                }
            }
        });
    }
}
