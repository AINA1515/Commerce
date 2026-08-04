package mg.aina.commerce.remise.entity;

import jakarta.persistence.*;
import mg.aina.commerce.utilisateur.entity.Utilisateur;

import java.sql.Timestamp;

@Entity
@Table(name = "historique_remise")
public class HistoriqueRemise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @Column(nullable = false)
    private Double pourcentage;

    @Column(name = "date_retour", nullable = false)
    private Timestamp dateRetour;

    @Column(name = "date_fin", nullable = false)
    private Timestamp dateFin;

    @Column(nullable = false)
    private Boolean disponibilite;

    @ManyToOne
    @JoinColumn(name = "id_type_changement", nullable = false)
    private TypeChangementRemise typeChangement;

    public HistoriqueRemise() {
    }

    public HistoriqueRemise(Integer id, Utilisateur utilisateur, Double pourcentage, Timestamp dateRetour, Timestamp dateFin, Boolean disponibilite, TypeChangementRemise typeChangement) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.pourcentage = pourcentage;
        this.dateRetour = dateRetour;
        this.dateFin = dateFin;
        this.disponibilite = disponibilite;
        this.typeChangement = typeChangement;
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

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Timestamp getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Timestamp dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public TypeChangementRemise getTypeChangement() {
        return typeChangement;
    }

    public void setTypeChangement(TypeChangementRemise typeChangement) {
        this.typeChangement = typeChangement;
    }
}