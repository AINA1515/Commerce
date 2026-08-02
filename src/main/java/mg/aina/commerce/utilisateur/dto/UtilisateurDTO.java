package mg.aina.commerce.utilisateur.dto;

import java.sql.Timestamp;

public class UtilisateurDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Integer idRole;
    private String nomRole;
    private String motDePasse;
    private Timestamp dateCreation;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(Integer id, String nom, String prenom, String email, Integer idRole, String nomRole, Timestamp dateCreation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.idRole = idRole;
        this.nomRole = nomRole;
        this.dateCreation = dateCreation;
    }
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
}