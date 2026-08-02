package com.commerce.module.produit.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stock_produit")
public class StockProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @Column(name = "prix_achat", nullable = false)
    private Double prixAchat;

    @Column(name = "prix_vente", nullable = false)
    private Double prixVente;

    @Column(name = "quantite_stock", nullable = false)
    private Integer quantiteStock;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public StockProduit() {
    }

    public StockProduit(Integer id, Produit produit, Double prixAchat, Double prixVente, Integer quantiteStock) {
        this.id = id;
        this.produit = produit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.quantiteStock = quantiteStock;
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

    public Double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Integer getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(Integer quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }
}