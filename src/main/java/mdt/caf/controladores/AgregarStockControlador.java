package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mdt.caf.metodos.Mensaje;
import mdt.caf.metodos.Metodos;

import static mdt.caf.metodos.Metodos.referenciaProducto;

public class AgregarStockControlador {
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
    TextField txtStockActual;
    @FXML
    TextField txtNuevoStock;
    @FXML
    private Button btnEditar;
    @FXML
    public void initialize(){
        btnValidar.setOnAction(e->{
            if(Metodos.validarProducto(txtClave)){
                txtClave.setDisable(true);
                btnValidar.setDisable(true);
                txtNuevoStock.setDisable(false);
                btnEditar.setDisable(false);
                txtNombre.setText(referenciaProducto.getNombre());
                txtUnidad.setText(referenciaProducto.getUnidad());
                txtPrecio.setText(String.valueOf(referenciaProducto.getPrecio()));
                txtStockActual.setText(String.valueOf(referenciaProducto.getStock()));
            }
            else if(!txtClave.getText().isEmpty()){
                Mensaje.error("No hay ningun producto registrado con esta clave");
            }
        });
        btnEditar.setOnAction(e->{
            Metodos.agregarStock(txtNuevoStock);
        });
    }
}
