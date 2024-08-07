package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mdt.caf.metodos.Metodos;
import mdt.caf.objetos.*;

import java.time.LocalTime;

import static mdt.caf.metodos.Configuradores.*;
import static mdt.caf.metodos.Metodos.*;

public class AppControlador {
    // *** Generales *** //
    @FXML
    MenuItem menuCerrarSesion;

    // *** Productos *** //

    @FXML
    TableView<Producto> tblProductos;
    @FXML
    private TableColumn<Producto, Integer> idColProd;
    @FXML
    private TableColumn<Producto, String> claveColProd;
    @FXML
    private TableColumn<Producto, String> nombreColProd;
    @FXML
    private TableColumn<Producto, String> unidadColProd;
    @FXML
    private TableColumn<Producto, Float> stockColProd;
    @FXML
    private TableColumn<Producto, Float> precioColProd;
    @FXML
    private TableColumn<Producto, Boolean> estatusColProd;
    @FXML
    private Button btnRegistrarProducto;
    @FXML
    private Button btnEditarProducto;
    @FXML
    private Button btnSuspenderProducto;
    @FXML
    private Button btnAgregarExistencias;
    @FXML
    private Button btnActualizarProductos;

    // *** Trabajadores *** //

    @FXML
    TableView<Trabajador> tblTrabajadores;
    @FXML
    private TableColumn<Trabajador, Integer> idColTrab;
    @FXML
    private TableColumn<Trabajador, String> nombreColTrab;
    @FXML
    private TableColumn<Trabajador, String> apellidosColTrab;
    @FXML
    private TableColumn<Trabajador, Integer> edadColTrab;
    @FXML
    private TableColumn<Trabajador, String> curpColTrab;
    @FXML
    private TableColumn<Trabajador, String> rfcColTrab;
    @FXML
    private TableColumn<Trabajador, String> nssColTrab;
    @FXML
    private TableColumn<Trabajador, String> telefonoColTrab;
    @FXML
    private TableColumn<Trabajador, LocalTime> entradaColTrab;
    @FXML
    private TableColumn<Trabajador, LocalTime> salidaColTrab;
    @FXML
    private TableColumn<Trabajador, Boolean> estatusColTrab;
    @FXML
    private Button btnRegistrarTrabajador;
    @FXML
    private Button btnEditarTrabajador;
    @FXML
    private Button btnEditarHorario;
    @FXML
    private Button btnSuspenderTrabajador;
    @FXML
    private Button btnActualizarTrabajadores;

    @FXML
    TableView<Membresia> tblMembresias;
    @FXML
    TableView<Cliente> tblClientes;
    @FXML
    Button btnRegistrarCliente;
    @FXML
    Button btnEditarCliente;
    @FXML
    Button btnAsignarMembresia;
    @FXML
    Button btnSuspenderCliente;
    @FXML
    Button btnBorrarCampoCliente;
    @FXML
    Button btnBuscarCliente;
    @FXML
    Button btnRegistrarMembresia;
    @FXML
    Button btnEditarMembresia;
    @FXML
    Button btnGestionarMembresia;
    @FXML
    Button btnSuspenderMembresia;
    @FXML
    Button btnBorrarCampoMembresia;
    @FXML
    Button btnBuscarMembresia;
    @FXML
    TextField txtCampoBusquedaMembresia;
    @FXML
    TableView<Renta> tblRentas;
    @FXML
    Button btnRegistrarRenta;
    @FXML
    Button btnEditarRenta;
    @FXML
    Button btnVerEquiposRenta;
    @FXML
    Button btnFinalizarRenta;
    @FXML
    Button btnBuscarRenta;
    @FXML
    Button btnBorrarCampoRenta;
    @FXML
    TextField txtCampoBusquedaRenta;
    @FXML
    TableView<Plan> tblPlanes;
    @FXML
    Button btnRegistrarPlan;
    @FXML
    Button btnEditarPlan;
    @FXML
    Button btnGestionarPlan;
    @FXML
    Button btnFinalizarPlan;
    @FXML
    Button btnBuscarPlan;
    @FXML
    Button btnBorrarCampoPlan;
    @FXML
    TextField txtCampoBusquedaPlan;
    //Producto

    @FXML
    public void initialize() {
        // <--- Módulo de Productos ---> //

        ajustarColumna(tblProductos);
        idColProd.setCellValueFactory(new PropertyValueFactory<>("id"));
        claveColProd.setCellValueFactory(new PropertyValueFactory<>("clave"));
        nombreColProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        unidadColProd.setCellValueFactory(new PropertyValueFactory<>("unidad"));
        stockColProd.setCellValueFactory(new PropertyValueFactory<>("stock"));
        precioColProd.setCellValueFactory(new PropertyValueFactory<>("precio"));
        estatusColProd.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        ajustarBoton(btnRegistrarProducto, "/iconos/registrar-producto.png", "Agregar Producto");
        ajustarBoton(btnEditarProducto, "/iconos/editar.png", "Editar Producto");
        ajustarBoton(btnSuspenderProducto, "/iconos/suspender.png", "Suspender Producto");
        ajustarBoton(btnAgregarExistencias, "/iconos/agregar-existencias.png", "Agregar Existencias");
        ajustarBoton(btnActualizarProductos, "/iconos/actualizar.png", "Actualizar");
        abrirVentana(btnRegistrarProducto, "/interfaces/registros/producto.fxml", "Registrar Producto");
        abrirVentana(btnEditarProducto, "/interfaces/ediciones/producto.fxml", "Editar Producto");
        abrirVentana(btnAgregarExistencias, "/interfaces/ediciones/stock.fxml", "Agregar Stock");
        abrirVentana(btnSuspenderProducto, "/interfaces/suspensiones/producto.fxml", "Suspender Producto");
        btnActualizarProductos.setOnAction(e ->{
            Metodos.mostrarTablaProductos(tblProductos);
        });

        // <--- Módulo de Trabajadores ---> //

        ajustarColumna(tblTrabajadores);
        idColTrab.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColTrab.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidosColTrab.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        edadColTrab.setCellValueFactory(new PropertyValueFactory<>("edad"));
        curpColTrab.setCellValueFactory(new PropertyValueFactory<>("curp"));
        rfcColTrab.setCellValueFactory(new PropertyValueFactory<>("rfc"));
        nssColTrab.setCellValueFactory(new PropertyValueFactory<>("nss"));
        telefonoColTrab.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
        entradaColTrab.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        salidaColTrab.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        estatusColTrab.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        ajustarBoton(btnRegistrarTrabajador, "/iconos/agregar-usuario.png", "Agregar Trabajador");
        ajustarBoton(btnEditarTrabajador, "/iconos/editar.png", "Editar Trabajador");
        ajustarBoton(btnEditarHorario, "/iconos/editar-horario.png", "Editar Horario");
        ajustarBoton(btnSuspenderTrabajador, "/iconos/suspender.png", "Suspender Trabajador");
        ajustarBoton(btnActualizarTrabajadores, "/iconos/actualizar.png", "Actualizar");
        abrirVentana(btnRegistrarTrabajador, "/interfaces/registros/trabajador.fxml", "Agregar Trabajador");
        abrirVentana(btnEditarTrabajador, "/interfaces/ediciones/trabajador.fxml", "Editar Trabajador");
        abrirVentana(btnEditarHorario, "/interfaces/ediciones/horario.fxml", "Editar Horario");
        abrirVentana(btnSuspenderTrabajador, "/interfaces/suspensiones/trabajador.fxml", "Suspender Trabajador");
        btnActualizarTrabajadores.setOnAction(e ->{
            Metodos.mostrarTablaTrabajadores(tblTrabajadores);
        });


        // <--- Módulo de Clientes ---> //

        ajustarColumna(tblClientes);
        ajustarBoton(btnRegistrarCliente, "/iconos/agregar-usuario.png", "Agregar Cliente");
        ajustarBoton(btnEditarCliente, "/iconos/editar.png", "Editar Cliente");
        ajustarBoton(btnAsignarMembresia, "/iconos/membresia.png", "Asignar Membresia");
        ajustarBoton(btnSuspenderCliente, "/iconos/suspender.png", "Suspender Cliente");
        ajustarBoton(btnBorrarCampoCliente, "/iconos/borrar.png", "Borrar");
        ajustarBoton(btnBuscarCliente, "/iconos/buscar.png", "Buscar");
        //borrarCampo(btnBorrarCampoCliente, txtCampoBusquedaCliente); borrar
        abrirVentana(btnRegistrarCliente, "/interfaces/registros/cliente.fxml", "Registrar Cliente");
        abrirVentana(btnEditarCliente, "/interfaces/ediciones/cliente.fxml", "Editar Cliente");
        abrirVentana(btnAsignarMembresia, "/interfaces/asignaciones/membresia.fxml", "Asignar Membresia");
        abrirVentana(btnSuspenderCliente, "/interfaces/suspensiones/cliente.fxml", "Suspender Cliente");


        // <--- Módulo de Membresias ---> //

        ajustarColumna(tblMembresias);
        ajustarBoton(btnRegistrarMembresia, "/iconos/registrar-producto.png", "Agregar Membresia");
        ajustarBoton(btnEditarMembresia, "/iconos/editar.png", "Editar Membresia");
        ajustarBoton(btnGestionarMembresia, "/iconos/gestionar-membresia2.png", "Gestionar Membresia");
        ajustarBoton(btnSuspenderMembresia, "/iconos/suspender-membresia.png", "Suspender Membresia");
        ajustarBoton(btnBuscarMembresia, "/iconos/buscar.png", "Buscar");
        ajustarBoton(btnBorrarCampoMembresia, "/iconos/borrar.png", "Borrar");
        abrirVentana(btnRegistrarMembresia, "/interfaces/registros/membresia.fxml", "Registrar Membresia");
        abrirVentana(btnEditarMembresia, "/interfaces/ediciones/membresia.fxml", "Editar Membresia");
        abrirVentana(btnGestionarMembresia, "/interfaces/gestiones/membresia.fxml", "Gestionar Membresia");
        abrirVentana(btnSuspenderMembresia, "/interfaces/suspensiones/membresia.fxml", "Suspender Membresia");

        // <--- Módulo de Rentas ---> //

        ajustarColumna(tblRentas);
        ajustarBoton(btnRegistrarRenta, "/iconos/rentar.png", "Rentar Equipo");
        ajustarBoton(btnEditarRenta, "/iconos/editar.png", "Editar Renta");
        ajustarBoton(btnVerEquiposRenta, "/iconos/equipos2.png", "Ver Equipos");
        ajustarBoton(btnFinalizarRenta, "/iconos/finalizar.png", "Finalizar Renta");
        ajustarBoton(btnBuscarRenta, "/iconos/buscar.png", "Buscar");
        ajustarBoton(btnBorrarCampoRenta, "/iconos/borrar.png", "Borrar");
        abrirVentana(btnRegistrarRenta, "/interfaces/registros/renta.fxml", "Registrar Renta");
        abrirVentana(btnEditarRenta, "/interfaces/ediciones/renta.fxml", "Editar Renta");
        abrirVentana(btnVerEquiposRenta, "/interfaces/gestiones/renta.fxml", "Ver Equipos");
        abrirVentana(btnFinalizarRenta, "/interfaces/suspensiones/renta.fxml", "Suspender Renta");

        // <--- Módulo de Planes de Mantenimiento ---> //

        ajustarColumna(tblPlanes);
        ajustarBoton(btnRegistrarPlan, "/iconos/registrar-producto.png", "Crear Plan de Mantenimiento");
        ajustarBoton(btnEditarPlan, "/iconos/editar.png", "Editar Plan de Mantenimiento");
        ajustarBoton(btnGestionarPlan, "/iconos/mantenimiento.png", "Detalles");
        ajustarBoton(btnFinalizarPlan, "/iconos/finalizar.png", "Finalizar Plan de Mantenimiento");
        ajustarBoton(btnBuscarPlan, "/iconos/buscar.png", "Buscar");
        ajustarBoton(btnBorrarCampoPlan, "/iconos/borrar.png", "Borrar");
        abrirVentana(btnRegistrarPlan, "/interfaces/registros/mantenimiento.fxml", "Registrar Mantenimiento");
        abrirVentana(btnEditarPlan, "/interfaces/ediciones/mantenimiento.fxml", "Editar Mantenimiento");
        abrirVentana(btnGestionarPlan, "/interfaces/gestiones/mantenimiento.fxml", "Gestionar Mantenimiento");
        abrirVentana(btnFinalizarPlan, "/interfaces/suspensiones/mantenimiento.fxml", "Editar Mantenimiento");

        // <--- Generales ---> //

        menuCerrarSesion.setOnAction(e->{
            stagePrincipal.close();
            sesionIniciada = null;
            stagePrincipal = null;
            referenciaStage = null;
            abrirVentana("/interfaces/inicio-sesion.fxml", "Control de Acceso");
        });
    }
}