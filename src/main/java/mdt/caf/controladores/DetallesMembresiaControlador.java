package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mdt.caf.metodos.Metodos;
import mdt.caf.objetos.Cliente;

import java.time.LocalDate;


public class DetallesMembresiaControlador {
    @FXML
    TableView<Cliente> tblClientes;
    @FXML
    private TableColumn<Cliente, Integer> idCol;
    @FXML
    private TableColumn<Cliente, String> nombreCol;
    @FXML
    private TableColumn<Cliente, String> apellidosCol;
    @FXML
    private TableColumn<Cliente, String> telefonoCol;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtMiembrosTotales;
    @FXML
    private TextField txtMiembrosDisponibles;
    @FXML
    private DatePicker dpProximoPago;
    @FXML
    private Button btnValidar;
    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidosCol.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        telefonoCol.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
        btnValidar.setOnAction(e->{
            Metodos.detallesMembresia(btnValidar, txtId, txtNombre,txtMiembrosTotales, txtMiembrosDisponibles, dpProximoPago, tblClientes);
        });
    }

}
