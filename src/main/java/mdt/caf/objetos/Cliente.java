package mdt.caf.objetos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends Usuario{
    @OneToOne
    @JoinColumn(name = "MEMBRESIA_ID")
    private Membresia membresia;
    public Cliente(){
        super();
        this.fechaRegistro = LocalDate.now();
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
}
