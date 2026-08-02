package com.commerce.module.produit.dto;

import java.sql.Timestamp;

public class StockProduitDTO {
    private Integer id;
    private Integer idProduit;
    private String nomProduit;
    private Double prixAchat;
    private Double prixVente;
    private Integer quantiteStock;
    private Timestamp dateModification;

    public StockProduitDTO() {
    }

    public StockProduitDTO(Integer id, Integer idProduit, String nomProduit, Double prixAchat, Double prixVente, Integer quantiteStock, Timestamp dateModification) {
        this.id = id;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.quantiteStock = quantiteStock;
        this.dateModification = dateModification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
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