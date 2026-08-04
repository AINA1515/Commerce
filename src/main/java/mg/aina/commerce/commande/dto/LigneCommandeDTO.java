package mg.aina.commerce.commande.dto;

import java.sql.Timestamp;

public class LigneCommandeDTO {
    private Integer id;
    private Integer idCommande;
    private Integer idProduit;
    private String nomProduit;
    private Integer quantite;
    private Integer idStatusLigneCommande;
    private String nomStatusLigneCommande;
    private Double montantPayee;
    private Timestamp dateModification;
    private Double prix;

    public LigneCommandeDTO() {
    }

    public LigneCommandeDTO(Integer id, Integer idCommande, Integer idProduit, String nomProduit, Integer quantite, Integer idStatusLigneCommande, String nomStatusLigneCommande, Double montantPayee, Timestamp dateModification, Double prix) {
        this.id = id;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.idStatusLigneCommande = idStatusLigneCommande;
        this.nomStatusLigneCommande = nomStatusLigneCommande;
        this.montantPayee = montantPayee;
        this.dateModification = dateModification;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
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

    public Integer getIdStatusLigneCommande() {
        return idStatusLigneCommande;
    }

    public void setIdStatusLigneCommande(Integer idStatusLigneCommande) {
        this.idStatusLigneCommande = idStatusLigneCommande;
    }

    public String getNomStatusLigneCommande() {
        return nomStatusLigneCommande;
    }

    public void setNomStatusLigneCommande(String nomStatusLigneCommande) {
        this.nomStatusLigneCommande = nomStatusLigneCommande;
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