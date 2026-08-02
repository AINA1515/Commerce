package com.commerce.module.commande.entity;

import com.commerce.module.client.entity.Client;
import com.commerce.module.utilisateur.entity.Utilisateur;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prix_total", nullable = false)
    private Double prixTotal;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction_commande", nullable = false)
    private TypeTransactionCommande typeTransactionCommande;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column(name = "montant_payee", nullable = false)
    private Double montantPayee;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public Commande() {
    }

    public Commande(Integer id, Double prixTotal, TypeTransactionCommande typeTransactionCommande, Utilisateur utilisateur, Client client, Double montantPayee) {
        this.id = id;
        this.prixTotal = prixTotal;
        this.typeTransactionCommande = typeTransactionCommande;
        this.utilisateur = utilisateur;
        this.client = client;
        this.montantPayee = montantPayee;
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

    public TypeTransactionCommande getTypeTransactionCommande() {
        return typeTransactionCommande;
    }

    public void setTypeTransactionCommande(TypeTransactionCommande typeTransactionCommande) {
        this.typeTransactionCommande = typeTransactionCommande;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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