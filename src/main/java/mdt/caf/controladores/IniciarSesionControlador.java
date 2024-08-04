package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import static mdt.caf.metodos.Configuradores.abrirVentana;
import static mdt.caf.metodos.Configuradores.ajustarFiltro;
import static mdt.caf.metodos.Metodos.*;

public class IniciarSesionControlador {
    @FXML
    private ComboBox<String> cmbTipoAcceso;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtClave;
    @FXML
    private Button btnIngresar;
    @FXML
    Button btnRestablecerClave;
    @FXML
    public void initialize(){
        abrirVentana(btnRestablecerClave, "/interfaces/reestablecer-clave.fxml", "Reestablecer Clave");
        ajustarFiltro(cmbTipoAcceso, "Trabajador", "Cliente");
        btnIngresar.setOnAction(e ->{
            if(iniciarSesion(cmbTipoAcceso, txtCorreo, txtClave)){
                abrirVentana("/interfaces/inicio.fxml","Sistema de Gestión Integral - CAF");
                stagePrincipal.close();
                stagePrincipal = referenciaStage;
                referenciaStage = null;
                stagePrincipal.setMaximized(true);
            }
        });
    }
}
