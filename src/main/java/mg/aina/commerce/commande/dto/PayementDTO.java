package mg.aina.commerce.commande.dto;

import java.sql.Timestamp;

public class PayementDTO {
    private Integer id;
    private Integer idLigneCommande;
    private Integer idTypePayement;
    private String nomTypePayement;
    private Double montant;
    private Timestamp dateModification;

    public PayementDTO() {
    }

    public PayementDTO(Integer id, Integer idLigneCommande, Integer idTypePayement, String nomTypePayement, Double montant, Timestamp dateModification) {
        this.id = id;
        this.idLigneCommande = idLigneCommande;
        this.idTypePayement = idTypePayement;
        this.nomTypePayement = nomTypePayement;
        this.montant = montant;
        this.dateModification = dateModification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Integer getIdTypePayement() {
        return idTypePayement;
    }

    public void setIdTypePayement(Integer idTypePayement) {
        this.idTypePayement = idTypePayement;
    }

    public String getNomTypePayement() {
        return nomTypePayement;
    }

    public void setNomTypePayement(String nomTypePayement) {
        this.nomTypePayement = nomTypePayement;
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