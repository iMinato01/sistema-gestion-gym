package mdt.caf.objetos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MEMBRESIAS")
public class Membresia {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PRECIO")
    private float precio;
    @Column(name = "FECHA_PAGO")
    private LocalDate fechaPago;
    @Column(name = "PROXIMO_PAGO")
    private LocalDate proximoPago;
    @Column(name = "MIEMBROS_TOTALES")
    private int miembrosTotales;
    @Column(name = "MIEMBROS_ACTUALES")
    private int miembrosActuales;
    @Column(name = "ESTATUS")
    private boolean estatus;
    @OneToMany(mappedBy = "membresia")
    List<Cliente> clientes;
    public Membresia(){
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDate getProximoPago() {
        return proximoPago;
    }

    public void setProximoPago(LocalDate proximoPago) {
        this.proximoPago = proximoPago;
    }

    public int getMiembrosTotales() {
        return miembrosTotales;
    }

    public void setMiembrosTotales(int miembrosTotales) {
        this.miembrosTotales = miembrosTotales;
    }

    public int getMiembrosActuales() {
        return miembrosActuales;
    }

    public void setMiembrosActuales(int miembrosActuales) {
        this.miembrosActuales = miembrosActuales;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente cliente) {
        clientes.add(cliente);
    }
}
