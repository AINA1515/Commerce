package com.commerce.module.fournisseur.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_transaction_fournisseur")
public class TypeTransactionFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public TypeTransactionFournisseur() {
    }

    public TypeTransactionFournisseur(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
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
}