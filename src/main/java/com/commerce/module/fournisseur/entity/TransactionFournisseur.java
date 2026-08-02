package com.commerce.module.fournisseur.entity;

import com.commerce.module.utilisateur.entity.Utilisateur;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction_fournisseur")
public class TransactionFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction_fournisseur", nullable = false)
    private TypeTransactionFournisseur typeTransactionFournisseur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "montantTotal", nullable = false)
    private Double montantTotal;

    @Column(name = "date_modification", insertable = false, updatable = false)
    private Timestamp dateModification;

    public TransactionFournisseur() {
    }

    public TransactionFournisseur(Integer id, TypeTransactionFournisseur typeTransactionFournisseur, Utilisateur utilisateur, Double montantTotal) {
        this.id = id;
        this.typeTransactionFournisseur = typeTransactionFournisseur;
        this.utilisateur = utilisateur;
        this.montantTotal = montantTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeTransactionFournisseur getTypeTransactionFournisseur() {
        return typeTransactionFournisseur;
    }

    public void setTypeTransactionFournisseur(TypeTransactionFournisseur typeTransactionFournisseur) {
        this.typeTransactionFournisseur = typeTransactionFournisseur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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