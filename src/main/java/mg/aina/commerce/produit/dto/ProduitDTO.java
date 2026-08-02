package mg.aina.commerce.produit.dto;

import java.sql.Timestamp;

public class ProduitDTO {
    private Integer id;
    private String nom;
    private String description;
    private Integer idTypeProduit;
    private String nomTypeProduit;
    private Integer stockMinimum;
    private Timestamp dateCreation;

    public ProduitDTO() {
    }

    public ProduitDTO(Integer id, String nom, String description, Integer idTypeProduit, String nomTypeProduit, Integer stockMinimum, Timestamp dateCreation) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.idTypeProduit = idTypeProduit;
        this.nomTypeProduit = nomTypeProduit;
        this.stockMinimum = stockMinimum;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdTypeProduit() {
        return idTypeProduit;
    }

    public void setIdTypeProduit(Integer idTypeProduit) {
        this.idTypeProduit = idTypeProduit;
    }

    public String getNomTypeProduit() {
        return nomTypeProduit;
    }

    public void setNomTypeProduit(String nomTypeProduit) {
        this.nomTypeProduit = nomTypeProduit;
    }

    public Integer getStockMinimum() {
        return stockMinimum;
    }

    public void setStockMinimum(Integer stockMinimum) {
        this.stockMinimum = stockMinimum;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
}