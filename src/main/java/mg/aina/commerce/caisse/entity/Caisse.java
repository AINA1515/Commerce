package mg.aina.commerce.caisse.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "caisse")
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double solde;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public Caisse() {
    }

    public Caisse(Integer id, Double solde) {
        this.id = id;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }
}