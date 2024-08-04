package mdt.caf.objetos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "PLANES")
public class Plan {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "ACTIVIDAD")
    private String actividad;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;
    @Column(name = "HORA_CREACION")
    private LocalTime horaCreacion;
    @Column(name = "FECHA_REALIZACION")
    private LocalDate fechaRealizacion;
    @Column(name = "HORA_REALIZACION")
    private LocalTime horaRealizacion;
    @OneToOne
    @JoinColumn(name = "CREADOR_ID")
    private Trabajador creador;
    @OneToOne
    @JoinColumn(name = "EQUIPO_ID")
    private Equipo equipo;
    @Column(name = "ESTATUS")
    private boolean estatus;
    public Plan(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public LocalTime getHoraRealizacion() {
        return horaRealizacion;
    }

    public void setHoraRealizacion(LocalTime horaRealizacion) {
        this.horaRealizacion = horaRealizacion;
    }

    public Trabajador getCreador() {
        return creador;
    }

    public void setCreador(Trabajador creador) {
        this.creador = creador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
