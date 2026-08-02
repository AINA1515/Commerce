package mg.aina.commerce.commande.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_transaction_commande")
public class TypeTransactionCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public TypeTransactionCommande() {
    }

    public TypeTransactionCommande(Integer id, String nom) {
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