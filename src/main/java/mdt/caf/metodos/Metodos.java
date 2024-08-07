package mdt.caf.metodos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mdt.caf.objetos.Cliente;
import mdt.caf.objetos.Producto;
import mdt.caf.objetos.Trabajador;
import mdt.caf.objetos.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;



public class Metodos {
    // **** Declaraciones globales **** //
    public static Usuario sesionIniciada;
    public static Stage stagePrincipal;
    public static Stage referenciaStage;
    public static Trabajador referenciaTrabajador;
    public static Producto referenciaProducto;
    public static Configuration config = new Configuration().configure();
    public static SessionFactory sessionFactory = config.buildSessionFactory();

    // **** Métodos de interacción a la base de datos **** //

    public static void registrarTrabajador(Trabajador trabajador) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(trabajador);
            session.getTransaction().commit();
            Mensaje.informacion("El trabajador fue registrado exitosamente");
        } catch (HibernateException e) {
            Mensaje.error("Ocurrió un error al guardar el trabajador\nError: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void registrarCliente(Cliente cliente) {
        if (cliente != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.persist(cliente);
                session.getTransaction().commit();
                Mensaje.informacion("El cliente fue registrado exitosamente");
            } catch (HibernateException e) {
                Mensaje.error("Ocurrió un error al guardar el cliente\nError: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            Mensaje.error("Cliente no valido");
        }
    }

    public static Cliente buscarCliente(String correo, String clave) {
        String hql = "FROM Cliente C WHERE C.correo = :correo AND C.clave = :clave";
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Cliente> query = session.createQuery(hql, Cliente.class);
            query.setParameter("correo", correo);
            query.setParameter("clave", clave);
            Cliente cliente = query.uniqueResult();
            session.getTransaction().commit();
            sesionIniciada = cliente;
            return cliente;
        } catch (HibernateException e) {
            Mensaje.error("Ocurrió un error al validar los datos\n Error: " + e.getMessage());
            return null;
        }
    }

    public static Trabajador buscarTrabajador(String correo, String clave) {
        String hql = "FROM Trabajador C WHERE C.correo = :correo AND C.clave = :clave";
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Trabajador> query = session.createQuery(hql, Trabajador.class);
            query.setParameter("correo", correo);
            query.setParameter("clave", clave);
            Trabajador trabajador = query.uniqueResult();
            session.getTransaction().commit();
            sesionIniciada = trabajador;
            return trabajador;
        } catch (HibernateException e) {
            Mensaje.error("Ocurrió un error al validar los datos\n Error: " + e.getMessage());
            return null;
        }
    }

    public static boolean correoDuplicado(String correo) {
        //Validar si el correo se encuentra en la base de datos, retornar false si no lo está, true si lo está
        if (validarCorreo(correo)) {
            try (Session session = sessionFactory.openSession()) {
                //Verificar el correo en la base de datos de los trabajadores
                String hqlTrabajador = "SELECT COUNT(c) FROM Trabajador c WHERE c.correo = :correo";
                Query<Long> queryTrabajador = session.createQuery(hqlTrabajador, Long.class);
                queryTrabajador.setParameter("correo", correo);
                Long trabajador = queryTrabajador.uniqueResult();
                //Verificar el correo en la base de datos de los clientes
                String hqlCliente = "SELECT COUNT(c) FROM Cliente c WHERE c.correo = :correo";
                Query<Long> queryCliente = session.createQuery(hqlCliente, Long.class);
                queryCliente.setParameter("correo", correo);
                Long cliente = queryCliente.uniqueResult();
                if (trabajador > 0 || cliente > 0) {
                    Mensaje.error("El correo ingresado ya está registrado");
                }
                else{
                    return false;
                }
            } catch (HibernateException e) {
                Mensaje.error("Ocurrió un error al validar los datos\n Error: " + e.getMessage());
            }
        } else {
            Mensaje.error("Ingresa un correo valido");
        }
        return true;
    }

    // **** Métodos de Validación **** //
    // *** Validaciones de datos de usuario *** //
    public static boolean validarNombre(String nombre) {
        if (nombre.isEmpty()) {
            Mensaje.error("El nombre no puede estar vacío");
            return false;
        } else {
            if (nombre.length() > 30) {
                Mensaje.error("La longitud del nombre debe ser menor a 30 caracteres");
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean validarApellidos(String apellidos) {
        if (apellidos.isEmpty()) {
            Mensaje.error("El apellido no puede estar vacío");
            return false;
        } else {
            if (apellidos.length() > 30) {
                Mensaje.error("La longitud de los apellidos debe ser menor a 30 caracteres");
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean validarEdad(String edad) {
        if (edad.isEmpty()) {
            Mensaje.error("La edad no puede estar vacía");
        } else {
            try {
                int edadNumerica = Integer.parseInt(edad);
                if (edadNumerica <= 0 || edadNumerica > 110) {
                    Mensaje.error("Debes ingresar una edad valida");
                } else {
                    return true;
                }
            } catch (NumberFormatException e) {
                Mensaje.error("La edad debe ser numérica");
            }
        }
        return false;
    }

    public static boolean validarNumeroTelefonico(String numeroTelefonico) {
        if (numeroTelefonico.isEmpty()) {
            Mensaje.error("El número telefónico no puede estar vacío");
        } else {
            if (numeroTelefonico.length() == 10) {
                try {
                    Float.parseFloat(numeroTelefonico);
                    return true;
                } catch (NumberFormatException e){
                    Mensaje.error("Debes ingresar un número de telefono válido");
                }
            } else {
                Mensaje.error("El número telefónico debe contener 10 caracteres");
            }
        }
        return  false;
    }

    public static boolean validarCorreo(String usuario) {
        if (usuario.isEmpty()) {
            Mensaje.error("El correo no puede estar vacío");
            return false;
        } else {
            if (usuario.contains("@") && usuario.contains(".")) {
                return true;
            } else {
                Mensaje.error("Debes ingresar un correo válido");
                return false;
            }
        }
    }

    public static boolean validarClave(String clave) {
        if (clave.isEmpty()) {
            Mensaje.error("La contraseña no puede estar vacía");
            return false;
        } else {
            if (clave.length() >= 8) {
                return true;
            } else {
                Mensaje.error("La contraseña debe contener al menos 8 caracteres");
                return false;
            }
        }
    }

    // *** Validación de datos del Trabajador *** //
    public static boolean validarCurp(String curp) {
        if (curp.isEmpty()) {
            Mensaje.error("La CURP no puede estar vacía");
        } else {
            if (curp.length() == 18) {
                return true;
            } else {
                Mensaje.error("La CURP debe contener 18 caracteres");
            }
        }
        return false;
    }

    public static boolean validarNss(String nss) {
        if (nss.isEmpty()) {
            Mensaje.error("El NSS no puede estar vacío");
        } else {
            if (nss.length() == 11) {
                try{
                    Float.parseFloat(nss);
                    return true;
                }catch (NumberFormatException e){
                    Mensaje.error("Debes ingresar un NSS válido");
                }
            } else {
                Mensaje.error("El NSS debe contener 11 caracteres");
            }
        }
        return false;
    }

    public static boolean validarRfc(String rfc) {
        if (rfc.isEmpty()) {
            Mensaje.error("El RFC no puede estar vacío");
            return false;
        } else {
            if (rfc.length() == 13) {
                return true;
            } else {
                Mensaje.error("El RFC debe contener 13 caracteres");
                return false;
            }
        }
    }

    public static boolean validarCategoria(String categoria) {
        if (categoria.isEmpty()) {
            Mensaje.error("La categoria no puede estar vacía");
            return false;
        } else {
            if (categoria.length() > 20) {
                Mensaje.error("La longitud de la categoria debe ser menor a 20 caracteres");
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean validarHora(String hora){
        if(hora.isEmpty()){
            Mensaje.error("El horario no puede estar vacío");
        }
        else{
            try{
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime.parse(hora, formato);
                return true;
            } catch (DateTimeParseException e){
                Mensaje.error("Debes ingresar un formato (HH:mm) y horario válido (0-24)");
            }
        }
        return false;
    }

    public static boolean validarSalario(String salario){
        if(salario.isEmpty()){
            Mensaje.error("El salario no puede estar vacío");
        }
        else{
            try {
                float salarioNumerico = Float.parseFloat(salario);
                if(salarioNumerico <= 0){
                    Mensaje.error("Debes ingresar un salario valido");
                }
                else{
                    return true;
                }
            } catch (NumberFormatException e){
                Mensaje.error("El salario debe ser numérico");
            }
        }
        return false;
    }

    // ****** Método Generales *******

    public static boolean iniciarSesion(ComboBox<String> cmbRol, TextField txtUsuario, TextField txtClave){
        String correo = txtUsuario.getText().toLowerCase();
        String clave = txtClave.getText();
        String rol = cmbRol.getValue();
        if(validarCorreo(correo) && validarClave(clave)){
            switch (rol){
                case "Trabajador" -> {
                    if(buscarTrabajador(correo, clave) == null){
                        Mensaje.error("El Trabajador no está registrado, o las credenciales son incorrectas");
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                case "Cliente" -> {
                    if(buscarCliente(correo, clave) == null){
                        Mensaje.error("El Cliente no está registrado, o las credenciales son incorrectas");
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                default -> Mensaje.error("Valor Indefinido\n" +rol);
            }
        }
        return false;
    }

    public static boolean crearTrabajador(TextField txtNombre, TextField txtApellidos, TextField txtEdad,
                                       TextField txtNumeroTelefonico, TextField txtCurp, TextField txtRfc, TextField txtNss,
                                       TextField txtCategoria, TextField txtHoraEntrada, TextField txtHoraSalida,
                                       TextField txtSalario, TextField txtCorreo, TextField txtClave){
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String edad = txtEdad.getText();
        String numeroTelefonico = txtNumeroTelefonico.getText();
        String curp = txtCurp.getText();
        String rfc = txtRfc.getText();
        String nss = txtNss.getText();
        String categoria = txtCategoria.getText();
        String horaEntrada = txtHoraEntrada.getText();
        String horaSalida = txtHoraSalida.getText();
        String salario = txtSalario.getText();
        String correo = txtCorreo.getText().toLowerCase();
        String clave = txtClave.getText();
        if(validarNombre(nombre) && validarApellidos(apellidos) && validarEdad(edad) && validarNumeroTelefonico(numeroTelefonico) &&
                validarCurp(curp) && validarRfc(rfc) && validarNss(nss) && validarCategoria(categoria) && validarHora(horaEntrada) &&
                validarHora(horaSalida) && validarSalario(salario) && validarCorreo(correo) && validarClave(clave)){
            if(!correoDuplicado(correo)){
                Trabajador nuevoTrabajador = new Trabajador();
                nuevoTrabajador.setNombre(nombre);
                nuevoTrabajador.setApellidos(apellidos);
                nuevoTrabajador.setEdad(Integer.parseInt(edad));
                nuevoTrabajador.setNumeroTelefonico(numeroTelefonico);
                nuevoTrabajador.setCurp(curp);
                nuevoTrabajador.setRfc(rfc);
                nuevoTrabajador.setNss(nss);
                nuevoTrabajador.setCategoria(categoria);
                //Estas 2 sentencias de abajo son las que deseo manejar con otro método
                nuevoTrabajador.setHoraEntrada(convertirHora(horaEntrada));
                nuevoTrabajador.setHoraSalida(convertirHora(horaSalida));
                nuevoTrabajador.setSalario(Float.parseFloat(salario));
                nuevoTrabajador.setCorreo(correo);
                nuevoTrabajador.setClave(clave);
                registrarTrabajador(nuevoTrabajador);
                return true;
            }
        }
        return false;
    }

    public static boolean crearCliente(TextField txtNombre, TextField txtApellidos, TextField txtEdad,
                                    TextField txtNumeroTelefonico,  TextField txtCorreo, TextField txtClave){
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String edad = txtEdad.getText();
        String numeroTelefonico = txtNumeroTelefonico.getText();
        String correo = txtCorreo.getText().toLowerCase();
        String clave = txtClave.getText();
        if(validarNombre(nombre) && validarApellidos(apellidos) && validarEdad(edad) && validarNumeroTelefonico(numeroTelefonico) &&
        validarCorreo(correo) && validarClave(clave)){
            if(!correoDuplicado(correo)){
                Cliente nuevoCliente = new Cliente();
                nuevoCliente.setNombre(nombre);
                nuevoCliente.setApellidos(apellidos);
                nuevoCliente.setEdad(Integer.parseInt(edad));
                nuevoCliente.setNumeroTelefonico(numeroTelefonico);
                nuevoCliente.setCorreo(correo);
                nuevoCliente.setClave(clave);
                registrarCliente(nuevoCliente);
                return true;
            }
        }
        return false;
    }
    public static LocalTime convertirHora(String hora) throws DateTimeParseException {
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(hora, formato);
        } catch (DateTimeParseException e){
            Mensaje.error("El formato de hora es incorrecto.\n (HH:mm)");
        }
        return null;
    }
    //Trabajador
    public static boolean validarTrabajadorId(TextField campoId) {
        String txtId = campoId.getText();
        if (!txtId.isEmpty()) {
            try (Session session = sessionFactory.openSession()) {
                int id = Integer.parseInt(txtId);
                String hql = "FROM Trabajador c WHERE c.id = :id ";
                session.beginTransaction();
                Query<Trabajador> query = session.createQuery(hql, Trabajador.class);
                query.setParameter("id", id);
                referenciaTrabajador = query.uniqueResult();
                session.getTransaction().commit();
                if (referenciaTrabajador == null) {
                    Mensaje.error("No hay ningún trabajador con el ID ingresado");
                }
                else if (!referenciaTrabajador.getEstatus()) {
                    Mensaje.error("El usuario con el ID '" + id + "' está suspendido");
                }
                else{
                    return true;
                }
            } catch (NumberFormatException e) {
                Mensaje.error("El ID debe ser un valor numérico");
            } catch (HibernateException e) {
                Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
            }
        }
        else{
            Mensaje.error("No puedes dejar el ID vacío");
        }
        return false;
    }

    public static void validarTrabajador(Button validar, TextField campoId, Button editar, TextField txtNombre, TextField txtApellidos,
                                            TextField txtEdad, TextField txtTelefono, TextField txtCurp, TextField txtRfc,
                                            TextField txtNss, TextField txtCategoria, TextField txtHoraEntrada, TextField txtHoraSalida,
                                            TextField txtSalario, TextField txtCorreo){
        if(validarTrabajadorId(campoId)){
            validar.setDisable(true);
            campoId.setDisable(true);
            editar.setDisable(false);
            txtNombre.setDisable(false);
            txtApellidos.setDisable(false);
            txtEdad.setDisable(false);
            txtTelefono.setDisable(false);
            txtCurp.setDisable(false);
            txtRfc.setDisable(false);
            txtNss.setDisable(false);
            txtCategoria.setDisable(false);
            txtSalario.setDisable(false);
            txtCorreo.setDisable(false);
            txtNombre.setText(referenciaTrabajador.getNombre());
            txtApellidos.setText(referenciaTrabajador.getApellidos());
            txtEdad.setText(String.valueOf(referenciaTrabajador.getEdad()));
            txtTelefono.setText(referenciaTrabajador.getNumeroTelefonico());
            txtCurp.setText(referenciaTrabajador.getCurp());
            txtRfc.setText(referenciaTrabajador.getRfc());
            txtNss.setText(referenciaTrabajador.getNss());
            txtCategoria.setText(referenciaTrabajador.getCategoria());
            txtHoraEntrada.setText(String.valueOf(referenciaTrabajador.getHoraEntrada()));
            txtHoraSalida.setText(String.valueOf(referenciaTrabajador.getHoraSalida()));
            txtSalario.setText(String.valueOf(referenciaTrabajador.getSalario()));
            txtCorreo.setText(referenciaTrabajador.getCorreo());
        }
    }

    public static void editarTrabajador(TextField txtNombre, TextField txtApellidos, TextField txtEdad, TextField txtTelefono,
                                        TextField txtCurp, TextField txtRfc, TextField txtNss, TextField txtCategoria,
                                        TextField txtSalario, TextField txtCorreo){
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String edadTexto = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String curp = txtCurp.getText();
        String rfc = txtRfc.getText();
        String nss = txtNss.getText();
        String categoria = txtCategoria.getText();
        String salarioTexto = txtSalario.getText();
        String correo = txtCorreo.getText();
        if(validarNombre(nombre) && validarApellidos(apellidos) && validarEdad(edadTexto) && validarNumeroTelefonico(telefono)
        && validarCurp(curp) && validarRfc(rfc) && validarNss(nss) && validarCategoria(categoria) && validarSalario(salarioTexto)){
            if(referenciaTrabajador.getCorreo().equals(correo) || !correoDuplicado(correo)){
                try(Session session = sessionFactory.openSession()){
                    int edad = Integer.parseInt(edadTexto);
                    float salario = Float.parseFloat(salarioTexto);
                    referenciaTrabajador.setNombre(nombre);
                    referenciaTrabajador.setApellidos(apellidos);
                    referenciaTrabajador.setEdad(edad);
                    referenciaTrabajador.setNumeroTelefonico(telefono);
                    referenciaTrabajador.setCurp(curp);
                    referenciaTrabajador.setRfc(rfc);
                    referenciaTrabajador.setNss(nss);
                    referenciaTrabajador.setCategoria(categoria);
                    referenciaTrabajador.setSalario(salario);
                    referenciaTrabajador.setCorreo(correo);
                    session.beginTransaction();
                    session.merge(referenciaTrabajador);
                    session.getTransaction().commit();
                    Mensaje.informacion("Se modificó la información del Trabajador exitosamente");
                    referenciaStage.close();
                } catch (NumberFormatException e){
                    Mensaje.error("La edad y el Salario deben ser valores numéricos");
                } catch (HibernateException e){
                    Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
                }
            }
        }
    }

    public static void validarTrabajador(TextField id, Button validar, TextField txtNombre, TextField txtApellidos, TextField txtEdad, TextField txtTelefono,
                                         TextField txtCategoria, TextField txtHoraEntrada, TextField txtHoraSalida, TextField txtNuevaHoraEntrada, TextField txtNuevaHoraSalida, Button editar){
        if(validarTrabajadorId(id)){
            validar.setDisable(true);
            id.setDisable(true);
            editar.setDisable(false);
            txtNuevaHoraEntrada.setDisable(false);
            txtNuevaHoraSalida.setDisable(false);
            txtNombre.setText(referenciaTrabajador.getNombre());
            txtApellidos.setText(referenciaTrabajador.getApellidos());
            txtEdad.setText(String.valueOf(referenciaTrabajador.getEdad()));
            txtTelefono.setText(referenciaTrabajador.getNumeroTelefonico());
            txtCategoria.setText(referenciaTrabajador.getCategoria());
            txtHoraEntrada.setText(String.valueOf(referenciaTrabajador.getHoraEntrada()));
            txtHoraSalida.setText(String.valueOf(referenciaTrabajador.getHoraSalida()));
        }
    }

    public static void editarHorario(TextField txtNuevaHoraEntrada, TextField txtNuevaHoraSalida){
        String horaEntrada = txtNuevaHoraEntrada.getText();
        String horaSalida = txtNuevaHoraSalida.getText();
        if(horaEntrada.isEmpty() || horaSalida.isEmpty()){
            Mensaje.error("Debes ingresar el nuevo horario");
            return;
        }
        if(convertirHora(horaEntrada) !=null && convertirHora(horaSalida) != null){
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                referenciaTrabajador.setHoraEntrada(convertirHora(horaEntrada));
                referenciaTrabajador.setHoraSalida(convertirHora(horaSalida));
                session.merge(referenciaTrabajador);
                session.getTransaction().commit();
                Mensaje.informacion("El horario del trabajador fue cambiado exitosamente");
                referenciaStage.close();
            }
        }
    }

    public static void validarTrabajador(TextField id, Button validar, TextField txtCorreo, TextField txtNombre, TextField txtApellidos, TextField txtEdad, TextField txtTelefono,
                                         TextField txtCurp, TextField txtRfc, TextField txtNss, TextField txtCategoria,
                                         TextField motivo, Button editar){
        if(validarTrabajadorId(id)){
            validar.setDisable(true);
            id.setDisable(true);
            editar.setDisable(false);
            motivo.setDisable(false);
            txtCorreo.setText(referenciaTrabajador.getCorreo());
            txtNombre.setText(referenciaTrabajador.getNombre());
            txtApellidos.setText(referenciaTrabajador.getApellidos());
            txtEdad.setText(String.valueOf(referenciaTrabajador.getEdad()));
            txtTelefono.setText(referenciaTrabajador.getNumeroTelefonico());
            txtCurp.setText(referenciaTrabajador.getCurp());
            txtRfc.setText(referenciaTrabajador.getRfc());
            txtNss.setText(referenciaTrabajador.getNss());
            txtCategoria.setText(referenciaTrabajador.getCategoria());
        }
    }

    public static void suspenderTrabajador(){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            referenciaTrabajador.setEstatus(false);
            session.merge(referenciaTrabajador);
            session.getTransaction().commit();
            Mensaje.informacion("El usuario fue suspendido exitosamente");
            referenciaStage.close();
        } catch (HibernateException e){
            Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
        }
    }

    public static boolean validarProducto(TextField txtClave){
        String clave = txtClave.getText();
        if(clave.isEmpty()){
            Mensaje.error("No puedes dejar la clave vacía");
        }
        else{
            try(Session session = sessionFactory.openSession()){
                String hql = "FROM Producto C WHERE C.clave = :clave";
                Query<Producto> productoQuery = session.createQuery(hql, Producto.class);
                productoQuery.setParameter("clave", clave);
                referenciaProducto = productoQuery.uniqueResult();
                if(referenciaProducto != null){
                    return true;
                }
            } catch (HibernateException e){
                Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
            }
        }
        return false;
    }

    public static boolean validarClaveProducto(TextField txtClave){
        String clave = txtClave.getText();
        if(clave.isEmpty()){
            Mensaje.error("No puedes dejar la clave vacía");
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarNombreProducto(TextField txtNombre){
        String nombre = txtNombre.getText();
        if(nombre.isEmpty()){
            Mensaje.error("No puedes dejar el nombre vacío");
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarUnidadProducto(TextField txtUnidad){
        String unidad = txtUnidad.getText();
        if(unidad.isEmpty()){
            Mensaje.error("No puedes dejar la unidad del producto vacía");
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarPrecioProducto(TextField txtPrecio){
        String precioTexto = txtPrecio.getText();
        if(precioTexto.isEmpty()){
            Mensaje.error("No puedes dejar el precio vacío");
        }
        else {
            try{
                float precio = Float.parseFloat(precioTexto);
                if(precio <= 0){
                    Mensaje.error("El precio del producto debe ser mayor a 0");
                }
                else{
                    return true;
                }
            } catch (NumberFormatException e){
                Mensaje.error("El precio del producto debe ser un valor numérico");
            }
        }
        return false;
    }

    public static boolean validarIngresoStock(TextField txtNuevoStock){
        String stockTexto = txtNuevoStock.getText();
        if(stockTexto.isEmpty()){
            Mensaje.error("No puedes dejar el stock vacío");
        }
        else {
            try{
                float precio = Float.parseFloat(stockTexto);
                if(precio <= 0){
                    Mensaje.error("La cantidad a ingresar debe ser mayor a 0");
                }
                else{
                    return true;
                }
            } catch (NumberFormatException e){
                Mensaje.error("Debes ingresar una cantidad valida");
            }
        }
        return false;
    }

    public static void crearProducto(TextField clave, TextField nombre, TextField unidad, TextField precio){
        if(validarClaveProducto(clave) && validarNombreProducto(nombre) && validarUnidadProducto(unidad) && validarPrecioProducto(precio)){
            if(!validarProducto(clave)){
                try(Session session = sessionFactory.openSession()){
                    session.beginTransaction();
                    referenciaProducto = new Producto();
                    referenciaProducto.setClave(clave.getText());
                    referenciaProducto.setNombre(nombre.getText());
                    referenciaProducto.setUnidad(unidad.getText());
                    referenciaProducto.setPrecio(Float.parseFloat(precio.getText()));
                    session.persist(referenciaProducto);
                    session.getTransaction().commit();
                    Mensaje.informacion("El producto fue registrado exitosamente");
                    referenciaStage.close();
                    referenciaProducto = null;
                } catch (HibernateException e){
                    Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
                }
            }
            else{
                Mensaje.error("Ya hay un producto registrado con esta clave");
            }
        }
    }

    public static void editarProducto(TextField txtNombre, TextField txtUnidad, TextField txtPrecio){
        if(validarNombreProducto(txtNombre) && validarUnidadProducto(txtUnidad) && validarPrecioProducto(txtPrecio)){
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                referenciaProducto.setNombre(txtNombre.getText());
                referenciaProducto.setUnidad(txtUnidad.getText());
                referenciaProducto.setPrecio(Float.parseFloat(txtPrecio.getText()));
                session.merge(referenciaProducto);
                session.getTransaction().commit();
                Mensaje.informacion("El producto fue editado exitosamente");
                referenciaProducto = null;
                referenciaStage.close();
            } catch (HibernateException e){
                Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
            }
        }
    }

    public static void agregarStock(TextField txtNuevoStock){
        if(validarIngresoStock(txtNuevoStock)){
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                referenciaProducto.setStock(referenciaProducto.getStock() + Float.parseFloat(txtNuevoStock.getText()));
                session.merge(referenciaProducto);
                session.getTransaction().commit();
                Mensaje.informacion("Se agregaron las cantidades exitosamente");
                referenciaStage.close();
            } catch (HibernateException e){
                Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
            }
        }
    }

    public static void suspenderProducto(){

    }

    public static void mostrarTablaProductos(TableView<Producto> tblProductos){
        String hql = "FROM Producto";
        try(Session session = sessionFactory.openSession()) {
            Query<Producto> query = session.createQuery(hql, Producto.class);
            List<Producto> productos = query.list();
                ObservableList<Producto> lista = FXCollections.observableArrayList(productos);
                tblProductos.setItems(lista);
        } catch (HibernateException e){
            Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
        }
    }

    public static void mostrarTablaTrabajadores(TableView<Trabajador> tblTrabajadores){
        String hql = "FROM Trabajador";
        try(Session session = sessionFactory.openSession()) {
            Query<Trabajador> query = session.createQuery(hql, Trabajador.class);
            List<Trabajador> trabajadores = query.list();
            ObservableList<Trabajador> lista = FXCollections.observableArrayList(trabajadores);
            tblTrabajadores.setItems(lista);
        } catch (HibernateException e){
            Mensaje.error("Ocurrió un error al interactuar con la base de datos\n Código: " + e.getMessage());
        }
    }
}
