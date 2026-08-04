package mg.aina.commerce.commande.dto;

import java.sql.Timestamp;

public class CommandeDTO {
    private Integer id;
    private Double prixTotal;
    private Integer idTypeTransactionCommande;
    private String nomTypeTransactionCommande;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Integer idClient;
    private String nomClient;
    private Double montantPayee;
    private Timestamp dateModification;

    public CommandeDTO() {
    }

    public CommandeDTO(Integer id, Double prixTotal, Integer idTypeTransactionCommande, String nomTypeTransactionCommande, Integer idUtilisateur, String nomUtilisateur, Integer idClient, String nomClient, Double montantPayee, Timestamp dateModification) {
        this.id = id;
        this.prixTotal = prixTotal;
        this.idTypeTransactionCommande = idTypeTransactionCommande;
        this.nomTypeTransactionCommande = nomTypeTransactionCommande;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.montantPayee = montantPayee;
        this.dateModification = dateModification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Integer getIdTypeTransactionCommande() {
        return idTypeTransactionCommande;
    }

    public void setIdTypeTransactionCommande(Integer idTypeTransactionCommande) {
        this.idTypeTransactionCommande = idTypeTransactionCommande;
    }

    public String getNomTypeTransactionCommande() {
        return nomTypeTransactionCommande;
    }

    public void setNomTypeTransactionCommande(String nomTypeTransactionCommande) {
        this.nomTypeTransactionCommande = nomTypeTransactionCommande;
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

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
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
}