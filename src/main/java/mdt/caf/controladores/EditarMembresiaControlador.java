package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class EditarMembresiaControlador {
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidadMiembros;
    @FXML
    private DatePicker dpFechaPago;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnValidar;
    @FXML
    public void initialize() {
        btnValidar.setOnAction(e -> {
            Metodos.validarMembresia(btnValidar, txtId, btnEditar, txtNombre, txtPrecio, txtCantidadMiembros, dpFechaPago);
        });
        btnEditar.setOnAction(e->{
            Metodos.editarMembresia(txtId, txtNombre, txtPrecio, txtCantidadMiembros, dpFechaPago);
        });
    }
}
