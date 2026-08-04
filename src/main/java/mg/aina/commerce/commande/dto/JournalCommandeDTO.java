package mg.aina.commerce.commande.dto;

public class JournalCommandeDTO {
    private Integer id;
    private Integer idCommande;
    private Integer idUtilisateur;
    private String nomUtilisateur;
    private Integer idClient;
    private String nomClient;
    private Double montantTotal;
    private Double montantPayee;

    public JournalCommandeDTO() {
    }

    public JournalCommandeDTO(Integer id, Integer idCommande, Integer idUtilisateur, String nomUtilisateur, Integer idClient, String nomClient, Double montantTotal, Double montantPayee) {
        this.id = id;
        this.idCommande = idCommande;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.montantTotal = montantTotal;
        this.montantPayee = montantPayee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Double getMontantPayee() {
        return montantPayee;
    }

    public void setMontantPayee(Double montantPayee) {
        this.montantPayee = montantPayee;
    }
}