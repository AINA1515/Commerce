package mg.aina.commerce.depense.entity;

import jakarta.persistence.*;
import mg.aina.commerce.utilisateur.entity.Utilisateur;

import java.sql.Timestamp;

@Entity
@Table(name = "historique_depense")
public class HistoriqueDepense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_type_depense", nullable = false)
    private TypeDepense typeDepense;

    @Column(nullable = false)
    private Double montant;

    private String description;

    @Column(name = "date_creation", insertable = false, updatable = false)
    private Timestamp dateCreation;

    public HistoriqueDepense() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
    public TypeDepense getTypeDepense() { return typeDepense; }
    public void setTypeDepense(TypeDepense typeDepense) { this.typeDepense = typeDepense; }
    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}
