package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Mensaje;
import mdt.caf.metodos.Metodos;

import static mdt.caf.metodos.Metodos.referenciaProducto;

public class EditarProductoControlador {
    @FXML
    private TextField txtClave;
    @FXML
    Button btnValidar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtUnidad;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button btnEditar;
    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            if(Metodos.validarProducto(txtClave)){
                txtClave.setDisable(true);
                btnValidar.setDisable(true);
                btnEditar.setDisable(false);
                txtNombre.setDisable(false);
                txtUnidad.setDisable(false);
                txtPrecio.setDisable(false);
                txtNombre.setText(referenciaProducto.getNombre());
                txtUnidad.setText(referenciaProducto.getUnidad());
                txtPrecio.setText(String.valueOf(referenciaProducto.getPrecio()));
            }
            else if(!txtClave.getText().isEmpty()){
                Mensaje.error("No hay ningun producto registrado con esta clave");
            }
        });
        btnEditar.setOnAction(e->{
            Metodos.editarProducto(txtNombre, txtUnidad, txtPrecio);
        });
    }
}
