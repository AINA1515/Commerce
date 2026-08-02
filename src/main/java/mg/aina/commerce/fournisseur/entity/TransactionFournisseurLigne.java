package mg.aina.commerce.fournisseur.entity;

import jakarta.persistence.*;
import mg.aina.commerce.produit.entity.Produit;

import java.sql.Timestamp;

@Entity
@Table(name = "transaction_fournisseur_ligne")
public class TransactionFournisseurLigne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur", nullable = false)
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_transaction_fournisseur", nullable = false)
    private TransactionFournisseur transactionFournisseur;

    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @Column(nullable = false)
    private Integer quantite;

    @Column(nullable = false)
    private Double montant;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public TransactionFournisseurLigne() {
    }

    public TransactionFournisseurLigne(Integer id, Fournisseur fournisseur, TransactionFournisseur transactionFournisseur, Produit produit, Integer quantite, Double montant) {
        this.id = id;
        this.fournisseur = fournisseur;
        this.transactionFournisseur = transactionFournisseur;
        this.produit = produit;
        this.quantite = quantite;
        this.montant = montant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public TransactionFournisseur getTransactionFournisseur() {
        return transactionFournisseur;
    }

    public void setTransactionFournisseur(TransactionFournisseur transactionFournisseur) {
        this.transactionFournisseur = transactionFournisseur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
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