package mdt.caf.objetos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TRABAJADORES")
public class Trabajador extends Usuario{
    @Column(name = "CURP")
    private String curp;
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "NSS")
    private String nss;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "HORA_ENTRADA")
    private LocalTime horaEntrada;
    @Column(name = "HORA_SALIDA")
    private LocalTime horaSalida;
    @Column(name = "SALARIO")
    private float salario;
    public Trabajador(){
        super();
        this.fechaRegistro = LocalDate.now();
        this.estatus = true;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
