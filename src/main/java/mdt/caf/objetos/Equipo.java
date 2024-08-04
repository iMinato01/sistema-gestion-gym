package mdt.caf.objetos;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "EQUIPOS")
public class Equipo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "ULTIMO_MANTENIMIENTO")
    private LocalDate ultimoMantenimiento;
    @Column(name = "ESTATUS")
    private boolean estatusActual;
    @Column(name = "ESTATUS_RENTA")
    private boolean estatusRenta;
    public Equipo(){
        estatusActual = true;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDate getUltimoMantenimiento() {
        return ultimoMantenimiento;
    }

    public void setUltimoMantenimiento(LocalDate ultimoMantenimiento) {
        this.ultimoMantenimiento = ultimoMantenimiento;
    }

    public boolean getEstatusActual() {
        return estatusActual;
    }

    public void setEstatusActual(boolean estatusActual) {
        this.estatusActual = estatusActual;
    }

    public boolean getEstatusRenta() {
        return estatusRenta;
    }

    public void setEstatusRenta(boolean estatusRenta) {
        this.estatusRenta = estatusRenta;
    }
}
