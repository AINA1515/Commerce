package com.commerce.module.produit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_transation_stock")
public class TypeTransationStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public TypeTransationStock() {
    }

    public TypeTransationStock(Integer id, String nom) {
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