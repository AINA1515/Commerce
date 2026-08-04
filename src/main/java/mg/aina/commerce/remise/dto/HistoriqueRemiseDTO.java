package mg.aina.commerce.remise.dto;

import java.sql.Timestamp;

public class HistoriqueRemiseDTO {
    private Integer id;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Double pourcentage;
    private Timestamp dateRetour;
    private Timestamp dateFin;
    private Boolean disponibilite;
    private Integer idTypeChangement;
    private String nomTypeChangement;

    public HistoriqueRemiseDTO() {
    }

    public HistoriqueRemiseDTO(Integer id, Integer idUtilisateur, String nomUtilisateur, Double pourcentage, Timestamp dateRetour, Timestamp dateFin, Boolean disponibilite, Integer idTypeChangement, String nomTypeChangement) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.pourcentage = pourcentage;
        this.dateRetour = dateRetour;
        this.dateFin = dateFin;
        this.disponibilite = disponibilite;
        this.idTypeChangement = idTypeChangement;
        this.nomTypeChangement = nomTypeChangement;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(Integer idUtilisateur) { this.idUtilisateur = idUtilisateur; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
    public Double getPourcentage() { return pourcentage; }
    public void setPourcentage(Double pourcentage) { this.pourcentage = pourcentage; }
    public Timestamp getDateRetour() { return dateRetour; }
    public void setDateRetour(Timestamp dateRetour) { this.dateRetour = dateRetour; }
    public Timestamp getDateFin() { return dateFin; }
    public void setDateFin(Timestamp dateFin) { this.dateFin = dateFin; }
    public Boolean getDisponibilite() { return disponibilite; }
    public void setDisponibilite(Boolean disponibilite) { this.disponibilite = disponibilite; }
    public Integer getIdTypeChangement() { return idTypeChangement; }
    public void setIdTypeChangement(Integer idTypeChangement) { this.idTypeChangement = idTypeChangement; }
    public String getNomTypeChangement() { return nomTypeChangement; }
    public void setNomTypeChangement(String nomTypeChangement) { this.nomTypeChangement = nomTypeChangement; }
}