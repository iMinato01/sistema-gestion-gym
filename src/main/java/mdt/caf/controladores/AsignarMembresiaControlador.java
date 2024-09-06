package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class AsignarMembresiaControlador {
    @FXML
    private Button btnValidarCliente;
    @FXML
    private TextField txtIdCliente;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Button btnValidarMembresia;
    @FXML
    private TextField txtIdMembresia;
    @FXML
    private TextField txtNombreMembresia;
    @FXML
    private TextField txtPrecio;
    @FXML
    private DatePicker dpFechaPago;
    @FXML
    private DatePicker dpProximoPago;
    @FXML
    private TextField txtEspaciosDisponibles;
    @FXML
    private Button btnAsignar;
    @FXML
    public void initialize(){
        btnValidarCliente.setOnAction(e->{
            Metodos.buscarCliente(btnValidarCliente, txtIdCliente, txtNombre, txtApellidos, txtEdad, txtTelefono, txtCorreo);
        });
        btnValidarMembresia.setOnAction(e->{
            Metodos.buscarMembresia(btnValidarMembresia, txtIdMembresia, txtNombreMembresia, txtPrecio, dpFechaPago,
                    dpProximoPago, txtEspaciosDisponibles);
        });

        btnAsignar.setOnAction(e->{
            Metodos.asignarMembresia(btnValidarMembresia,btnValidarCliente);
        });
    }
}
