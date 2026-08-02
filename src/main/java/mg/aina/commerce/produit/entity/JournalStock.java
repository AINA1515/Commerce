package mg.aina.commerce.produit.entity;

import jakarta.persistence.*;
import mg.aina.commerce.utilisateur.entity.Utilisateur;

import java.sql.Timestamp;

@Entity
@Table(name = "journal_stock")
public class JournalStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction_stock", nullable = false)
    private TypeTransationStock typeTransationStock;

    @Column(nullable = false)
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public JournalStock() {
    }

    public JournalStock(Integer id, Produit produit, TypeTransationStock typeTransationStock, Integer quantite, Utilisateur utilisateur) {
        this.id = id;
        this.produit = produit;
        this.typeTransationStock = typeTransationStock;
        this.quantite = quantite;
        this.utilisateur = utilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public TypeTransationStock getTypeTransationStock() {
        return typeTransationStock;
    }

    public void setTypeTransationStock(TypeTransationStock typeTransationStock) {
        this.typeTransationStock = typeTransationStock;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }
}