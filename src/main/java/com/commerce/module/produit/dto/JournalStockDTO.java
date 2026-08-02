package com.commerce.module.produit.dto;

import java.sql.Timestamp;

public class JournalStockDTO {
    private Integer id;
    private Integer idProduit;
    private String nomProduit;
    private Integer idTypeTransationStock;
    private String nomTypeTransationStock;
    private Integer quantite;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Timestamp dateModification;

    public JournalStockDTO() {
    }

    public JournalStockDTO(Integer id, Integer idProduit, String nomProduit, Integer idTypeTransationStock, String nomTypeTransationStock, Integer quantite, Integer idUtilisateur, String nomUtilisateur, Timestamp dateModification) {
        this.id = id;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.idTypeTransationStock = idTypeTransationStock;
        this.nomTypeTransationStock = nomTypeTransationStock;
        this.quantite = quantite;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
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

    public Integer getIdTypeTransationStock() {
        return idTypeTransationStock;
    }

    public void setIdTypeTransationStock(Integer idTypeTransationStock) {
        this.idTypeTransationStock = idTypeTransationStock;
    }

    public String getNomTypeTransationStock() {
        return nomTypeTransationStock;
    }

    public void setNomTypeTransationStock(String nomTypeTransationStock) {
        this.nomTypeTransationStock = nomTypeTransationStock;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }
}