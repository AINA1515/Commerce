package mg.aina.commerce.produit.dto;

import java.sql.Timestamp;

public class JournalStockDTO {
    private Integer idProduit;
    private String nomProduit;
    private String nomTypeTransactionStock;
    private Integer quantite;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Timestamp dateModification;

    public JournalStockDTO() {
    }

    public JournalStockDTO( Integer idProduit, String nomProduit, String nomTypeTransactionStock, Integer quantite, Integer idUtilisateur, String nomUtilisateur, Timestamp dateModification) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.nomTypeTransactionStock = nomTypeTransactionStock;
        this.quantite = quantite;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.dateModification = dateModification;
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

    public String getNomTypeTransactionStock() {
        return nomTypeTransactionStock;
    }

    public void setNomTypeTransactionStock(String nomTypeTransactionStock) {
        this.nomTypeTransactionStock = nomTypeTransactionStock;
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