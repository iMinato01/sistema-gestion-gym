package mdt.caf.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import static mdt.caf.metodos.Configuradores.*;
import static mdt.caf.metodos.Metodos.*;

public class AppControlador {
    @FXML
    TableView<String> tblProductos;
    @FXML
    TableView<String> tblTrabajadores;
    @FXML
    TableView<String> tblMembresias;
    @FXML
    Button btnRegistrarProducto;
    @FXML
    Button btnEditarProducto;
    @FXML
    Button btnSuspenderProducto;
    @FXML
    Button btnAgregarExistencias;
    @FXML
    Button btnBuscarProducto;
    @FXML
    Button btnBorrarCampoProducto;
    @FXML
    TextField txtCampoBusquedaProducto;
    @FXML
    Button btnRegistrarTrabajador;
    @FXML
    MenuItem menuCerrarSesion;
    @FXML
    Button btnEditarTrabajador;
    @FXML
    Button btnBorrarCampoTrabajador;
    @FXML
    TextField txtCampoBusquedaTrabajador;
    @FXML
    Button btnBuscarTrabajador;
    @FXML
    Button btnSuspenderTrabajador;
    @FXML
    Button btnEditarHorario;
    @FXML
    TableView<String> tblClientes;
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
    TextField txtCampoBusquedaCliente;
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
    TableView<String> tblRentas;
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
    TableView<String> tblPlanes;
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
    @FXML
    public void initialize() {

        // <--- Módulo de Clientes ---> //

        ajustarColumna(tblClientes);
        ajustarBoton(btnRegistrarCliente, "/iconos/agregar-usuario.png", "Agregar Cliente");
        ajustarBoton(btnEditarCliente, "/iconos/editar.png", "Editar Cliente");
        ajustarBoton(btnAsignarMembresia, "/iconos/membresia.png", "Asignar Membresia");
        ajustarBoton(btnSuspenderCliente, "/iconos/suspender.png", "Suspender Cliente");
        ajustarBoton(btnBorrarCampoCliente, "/iconos/borrar.png", "Borrar");
        ajustarBoton(btnBuscarCliente, "/iconos/buscar.png", "Buscar");
        borrarCampo(btnBorrarCampoCliente, txtCampoBusquedaCliente);
        abrirVentana(btnRegistrarCliente, "/interfaces/registros/cliente.fxml", "Registrar Cliente");
        abrirVentana(btnEditarCliente, "/interfaces/ediciones/cliente.fxml", "Editar Cliente");
        abrirVentana(btnAsignarMembresia, "/interfaces/asignaciones/membresia.fxml", "Asignar Membresia");
        abrirVentana(btnSuspenderCliente, "/interfaces/suspensiones/cliente.fxml", "Suspender Cliente");

        // <--- Módulo de Productos ---> //

        ajustarColumna(tblProductos);
        ajustarBoton(btnRegistrarProducto, "/iconos/registrar-producto.png", "Agregar Producto");
        ajustarBoton(btnEditarProducto, "/iconos/editar.png", "Editar Producto");
        ajustarBoton(btnSuspenderProducto, "/iconos/suspender.png", "Suspender Producto");
        ajustarBoton(btnAgregarExistencias, "/iconos/agregar-existencias.png", "Agregar Existencias");
        ajustarBoton(btnBuscarProducto, "/iconos/buscar.png", "Buscar");
        ajustarBoton(btnBorrarCampoProducto, "/iconos/borrar.png", "Borrar");
        borrarCampo(btnBorrarCampoProducto, txtCampoBusquedaProducto);
        abrirVentana(btnRegistrarProducto, "/interfaces/registros/producto.fxml", "Registrar Producto");
        abrirVentana(btnEditarProducto, "/interfaces/ediciones/producto.fxml", "Editar Producto");
        abrirVentana(btnAgregarExistencias, "/interfaces/ediciones/stock.fxml", "Agregar Stock");
        abrirVentana(btnSuspenderProducto, "/interfaces/suspensiones/producto.fxml", "Suspender Producto");

        // <--- Módulo de Trabajadores ---> //

        ajustarColumna(tblTrabajadores);
        ajustarBoton(btnRegistrarTrabajador, "/iconos/agregar-usuario.png", "Agregar Trabajador");
        ajustarBoton(btnEditarTrabajador, "/iconos/editar.png", "Editar Trabajador");
        ajustarBoton(btnEditarHorario, "/iconos/editar-horario.png", "Editar Horario");
        ajustarBoton(btnSuspenderTrabajador, "/iconos/suspender.png", "Suspender Trabajador");
        ajustarBoton(btnBorrarCampoTrabajador, "/iconos/borrar.png", "Borrar");
        ajustarBoton(btnBuscarTrabajador, "/iconos/buscar.png", "Buscar");
        borrarCampo(btnBorrarCampoTrabajador, txtCampoBusquedaTrabajador);
        abrirVentana(btnRegistrarTrabajador, "/interfaces/registros/trabajador.fxml", "Agregar Trabajador");
        abrirVentana(btnEditarTrabajador, "/interfaces/ediciones/trabajador.fxml", "Editar Trabajador");
        abrirVentana(btnEditarHorario, "/interfaces/ediciones/horario.fxml", "Editar Horario");
        abrirVentana(btnSuspenderTrabajador, "/interfaces/suspensiones/trabajador.fxml", "Suspender Trabajador");

        // <--- Módulo de Membresias ---> //

        ajustarColumna(tblMembresias);
        ajustarBoton(btnRegistrarMembresia, "/iconos/registrar-producto.png", "Agregar Membresia");
        ajustarBoton(btnEditarMembresia, "/iconos/editar.png", "Editar Membresia");
        ajustarBoton(btnGestionarMembresia, "/iconos/gestionar-membresia2.png", "Gestionar Membresia");
        ajustarBoton(btnSuspenderMembresia, "/iconos/suspender-membresia.png", "Suspender Membresia");
        ajustarBoton(btnBuscarMembresia, "/iconos/buscar.png", "Buscar");
        ajustarBoton(btnBorrarCampoMembresia, "/iconos/borrar.png", "Borrar");
        borrarCampo(btnBorrarCampoMembresia, txtCampoBusquedaMembresia);
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
        borrarCampo(btnBorrarCampoRenta, txtCampoBusquedaRenta);
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
        borrarCampo(btnBorrarCampoPlan, txtCampoBusquedaPlan);
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