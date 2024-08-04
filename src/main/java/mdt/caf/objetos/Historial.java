package mdt.caf.objetos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Historial {
    private int id; //El ID será asignado por el DBMS
    private int idEmisor; //Será el ID del usuario del que proviene el historial
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    public Historial(){
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
