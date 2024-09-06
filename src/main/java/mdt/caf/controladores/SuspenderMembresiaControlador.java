package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class SuspenderMembresiaControlador {
    @FXML
    private Button btnValidar;
    @FXML
    private Button btnSuspender;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidadMiembros;
    @FXML
    private TextField txtMiembrosActuales;
    @FXML
    private TextField txtMiembrosDisponibles;
    @FXML
    private DatePicker dpFechaPago;
    @FXML
    private DatePicker dpProximoPago;
    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            Metodos.validarMembresia(txtId, btnValidar, btnSuspender, txtNombre, txtPrecio, txtCantidadMiembros,
                    txtMiembrosActuales, txtMiembrosDisponibles, dpFechaPago, dpProximoPago);
        });
        btnSuspender.setOnAction(e->{
            Metodos.suspenderMembresia();
        });
    }
}
