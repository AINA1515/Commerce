package mg.aina.commerce.commande.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payement")
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_ligne_commande", nullable = false)
    private LigneCommande ligneCommande;

    @ManyToOne
    @JoinColumn(name = "id_type_payement", nullable = false)
    private TypePayement typePayement;

    @Column(nullable = false)
    private Double montant;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public Payement() {
    }

    public Payement(Integer id, LigneCommande ligneCommande, TypePayement typePayement, Double montant) {
        this.id = id;
        this.ligneCommande = ligneCommande;
        this.typePayement = typePayement;
        this.montant = montant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public TypePayement getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(TypePayement typePayement) {
        this.typePayement = typePayement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }
}