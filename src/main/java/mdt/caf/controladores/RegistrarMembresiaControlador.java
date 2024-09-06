package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class RegistrarMembresiaControlador {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidadMiembros;
    @FXML
    private TextField txtDiasPorPeriodo;
    @FXML
    private DatePicker dpFechaPago;
    @FXML
    private Button btnRegistrar;
    @FXML
    public void initialize(){
        btnRegistrar.setOnAction(e->{
            Metodos.crearMembresia(txtNombre,txtPrecio,txtCantidadMiembros,txtDiasPorPeriodo, dpFechaPago);
        });
    }
}
