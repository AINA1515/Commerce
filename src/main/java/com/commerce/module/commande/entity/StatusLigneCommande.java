package com.commerce.module.commande.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "status_ligne_commande")
public class StatusLigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public StatusLigneCommande() {
    }

    public StatusLigneCommande(Integer id, String nom) {
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