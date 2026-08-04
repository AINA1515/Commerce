package mg.aina.commerce.fournisseur.dto;

import java.sql.Timestamp;

public class TransactionFournisseurLigneDTO {
    private Integer idFournisseur;
    private String nomFournisseur;
    private Integer idTransactionFournisseur;
    private Integer idProduit;
    private String nomProduit;
    private Integer quantite;
    private Double montant;
    private Timestamp dateCreation;

    public TransactionFournisseurLigneDTO() {
    }

    public TransactionFournisseurLigneDTO(Integer idFournisseur, String nomFournisseur, Integer idTransactionFournisseur, Integer idProduit, String nomProduit, Integer quantite, Double montant, Timestamp dateCreation) {
        this.idFournisseur = idFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.idTransactionFournisseur = idTransactionFournisseur;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.montant = montant;
        this.dateCreation = dateCreation;
    }

    public Integer getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public Integer getIdTransactionFournisseur() {
        return idTransactionFournisseur;
    }

    public void setIdTransactionFournisseur(Integer idTransactionFournisseur) {
        this.idTransactionFournisseur = idTransactionFournisseur;
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

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
}