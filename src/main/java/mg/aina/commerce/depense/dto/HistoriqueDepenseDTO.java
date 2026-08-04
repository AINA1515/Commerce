package mg.aina.commerce.depense.dto;

import java.sql.Timestamp;

public class HistoriqueDepenseDTO {
    private Integer id;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Integer idTypeDepense;
    private String nomTypeDepense;
    private Double montant;
    private String description;
    private Timestamp dateCreation;

    public HistoriqueDepenseDTO() {
    }

    public HistoriqueDepenseDTO(Integer id, Integer idUtilisateur, String nomUtilisateur, Integer idTypeDepense, String nomTypeDepense, Double montant, String description, Timestamp dateCreation) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.idTypeDepense = idTypeDepense;
        this.nomTypeDepense = nomTypeDepense;
        this.montant = montant;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(Integer idUtilisateur) { this.idUtilisateur = idUtilisateur; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
    public Integer getIdTypeDepense() { return idTypeDepense; }
    public void setIdTypeDepense(Integer idTypeDepense) { this.idTypeDepense = idTypeDepense; }
    public String getNomTypeDepense() { return nomTypeDepense; }
    public void setNomTypeDepense(String nomTypeDepense) { this.nomTypeDepense = nomTypeDepense; }
    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}
