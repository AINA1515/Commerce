package mg.aina.commerce.fournisseur.dto;

import java.sql.Timestamp;

public class TransactionFournisseurDTO {
    private Integer id;
    private Integer idTypeTransactionFournisseur;
    private String nomTypeTransactionFournisseur;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Double montantTotal;
    private Timestamp dateModification;

    public TransactionFournisseurDTO() {
    }

    public TransactionFournisseurDTO(Integer id, Integer idTypeTransactionFournisseur, String nomTypeTransactionFournisseur, Integer idUtilisateur, String nomUtilisateur, Double montantTotal, Timestamp dateModification) {
        this.id = id;
        this.idTypeTransactionFournisseur = idTypeTransactionFournisseur;
        this.nomTypeTransactionFournisseur = nomTypeTransactionFournisseur;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.montantTotal = montantTotal;
        this.dateModification = dateModification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTypeTransactionFournisseur() {
        return idTypeTransactionFournisseur;
    }

    public void setIdTypeTransactionFournisseur(Integer idTypeTransactionFournisseur) {
        this.idTypeTransactionFournisseur = idTypeTransactionFournisseur;
    }

    public String getNomTypeTransactionFournisseur() {
        return nomTypeTransactionFournisseur;
    }

    public void setNomTypeTransactionFournisseur(String nomTypeTransactionFournisseur) {
        this.nomTypeTransactionFournisseur = nomTypeTransactionFournisseur;
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

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Timestamp getDateModification() {
        return dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }
}