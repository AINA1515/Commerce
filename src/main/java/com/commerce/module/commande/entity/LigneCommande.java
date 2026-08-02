package com.commerce.module.commande.entity;

import com.commerce.module.produit.entity.Produit;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ligne_commande")
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @Column(nullable = false)
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "id_status_ligne_commande", nullable = false)
    private StatusLigneCommande statusLigneCommande;

    @Column(name = "montant_payee", nullable = false)
    private Double montantPayee;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    @Column(nullable = false)
    private Double prix;

    public LigneCommande() {
    }

    public LigneCommande(Integer id, Commande commande, Produit produit, Integer quantite, StatusLigneCommande statusLigneCommande, Double montantPayee, Double prix) {
        this.id = id;
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
        this.statusLigneCommande = statusLigneCommande;
        this.montantPayee = montantPayee;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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

    public StatusLigneCommande getStatusLigneCommande() {
        return statusLigneCommande;
    }

    public void setStatusLigneCommande(StatusLigneCommande statusLigneCommande) {
        this.statusLigneCommande = statusLigneCommande;
    }

    public Double getMontantPayee() {
        return montantPayee;
    }

    public void setMontantPayee(Double montantPayee) {
        this.montantPayee = montantPayee;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}