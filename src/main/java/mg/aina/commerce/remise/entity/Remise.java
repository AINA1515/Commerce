package mg.aina.commerce.remise.entity;

import jakarta.persistence.*;
import mg.aina.commerce.produit.entity.Produit;
import mg.aina.commerce.utilisateur.entity.Utilisateur;

import java.sql.Timestamp;

@Entity
@Table(name = "remise")
public class Remise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @Column(nullable = false)
    private Double pourcentage;

    @Column(name = "date_debut", nullable = false)
    private Timestamp dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Timestamp dateFin;

    @Column(nullable = false)
    private Boolean disponiblite;

    public Remise() {
    }

    public Remise(Integer id, Utilisateur utilisateur, Produit produit, Double pourcentage, Timestamp dateDebut, Timestamp dateFin, Boolean disponiblite) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.produit = produit;
        this.pourcentage = pourcentage;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.disponiblite = disponiblite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getDisponiblite() {
        return disponiblite;
    }

    public void setDisponiblite(Boolean disponiblite) {
        this.disponiblite = disponiblite;
    }
}