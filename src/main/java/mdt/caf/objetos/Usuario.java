package mdt.caf.objetos;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public class Usuario {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "NOMBRE")
    protected String nombre;
    @Column(name = "APELLIDOS")
    protected String apellidos;
    @Column(name = "EDAD")
    protected int edad;
    @Column(name = "NUMERO_TELEFONICO")
    protected String numeroTelefonico;
    @Column(name = "FECHA_REGISTRO")
    protected LocalDate fechaRegistro;
    @Column(name = "CORREO")
    protected String correo;
    @Column(name = "CLAVE")
    protected String clave;
    @Column(name = "ESTATUS")
    protected boolean estatus;
    public Usuario(){
        //Se asignarán los valores con los setters de las clases hijas
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
