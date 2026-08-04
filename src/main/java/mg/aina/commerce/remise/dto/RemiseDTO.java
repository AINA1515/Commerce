package mg.aina.commerce.remise.dto;

import java.sql.Timestamp;

public class RemiseDTO {
    private Integer id;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Integer idProduit;
    private String nomProduit;
    private Double pourcentage;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private Boolean disponiblite;

    public RemiseDTO() {
    }

    public RemiseDTO(Integer id, Integer idUtilisateur, String nomUtilisateur, Integer idProduit, String nomProduit, Double pourcentage, Timestamp dateDebut, Timestamp dateFin, Boolean disponiblite) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.pourcentage = pourcentage;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.disponiblite = disponiblite;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(Integer idUtilisateur) { this.idUtilisateur = idUtilisateur; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
    public Integer getIdProduit() { return idProduit; }
    public void setIdProduit(Integer idProduit) { this.idProduit = idProduit; }
    public String getNomProduit() { return nomProduit; }
    public void setNomProduit(String nomProduit) { this.nomProduit = nomProduit; }
    public Double getPourcentage() { return pourcentage; }
    public void setPourcentage(Double pourcentage) { this.pourcentage = pourcentage; }
    public Timestamp getDateDebut() { return dateDebut; }
    public void setDateDebut(Timestamp dateDebut) { this.dateDebut = dateDebut; }
    public Timestamp getDateFin() { return dateFin; }
    public void setDateFin(Timestamp dateFin) { this.dateFin = dateFin; }
    public Boolean getDisponiblite() { return disponiblite; }
    public void setDisponiblite(Boolean disponiblite) { this.disponiblite = disponiblite; }
}