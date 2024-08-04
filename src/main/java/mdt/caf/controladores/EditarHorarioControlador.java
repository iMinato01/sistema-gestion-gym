package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Metodos;

public class EditarHorarioControlador {
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
    private TextField txtCategoria;
    @FXML
    private TextField txtHoraEntrada;
    @FXML
    private TextField txtHoraSalida;
    @FXML
    private TextField txtNuevaHoraEntrada;
    @FXML
    private TextField txtNuevaHoraSalida;
    @FXML
    Button btnEditar;

    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            Metodos.validarTrabajador(txtId, btnValidar, txtNombre, txtApellidos, txtEdad, txtTelefono, txtCategoria,
                    txtHoraEntrada, txtHoraSalida, txtNuevaHoraEntrada, txtNuevaHoraSalida, btnEditar);
        });
        btnEditar.setOnAction(e->{
        Metodos.editarHorario(txtNuevaHoraEntrada, txtNuevaHoraSalida);
        });
    }
}
