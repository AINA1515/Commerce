package mg.aina.commerce.remise.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_changement_remise")
public class TypeChangementRemise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public TypeChangementRemise() {
    }

    public TypeChangementRemise(Integer id, String nom) {
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