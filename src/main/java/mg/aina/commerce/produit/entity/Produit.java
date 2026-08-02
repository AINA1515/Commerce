package mg.aina.commerce.produit.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_type_produit", nullable = false)
    private TypeProduit typeProduit;

    @Column(name = "stock_minimum", nullable = false)
    private Integer stockMinimum;

    @Column(name = "date_creation", insertable = false, updatable = false)
    private Timestamp dateCreation;

    public Produit() {
    }

    public Produit(Integer id, String nom, String description, TypeProduit typeProduit, Integer stockMinimum) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.typeProduit = typeProduit;
        this.stockMinimum = stockMinimum;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }

    public Integer getStockMinimum() {
        return stockMinimum;
    }

    public void setStockMinimum(Integer stockMinimum) {
        this.stockMinimum = stockMinimum;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
}