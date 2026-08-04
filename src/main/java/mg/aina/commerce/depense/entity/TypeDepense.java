package mg.aina.commerce.depense.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_depense")
public class TypeDepense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public TypeDepense() {
    }

    public TypeDepense(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
