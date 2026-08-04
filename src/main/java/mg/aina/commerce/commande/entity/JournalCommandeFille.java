package mg.aina.commerce.commande.entity;

import jakarta.persistence.*;
import mg.aina.commerce.client.entity.Client;
import mg.aina.commerce.utilisateur.entity.Utilisateur;

@Entity
@Table(name = "journal_commande_fille")
public class JournalCommandeFille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_ligne_commande", nullable = false)
    private LigneCommande ligneCommande;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column(name = "montant_total", nullable = false)
    private Double montantTotal;

    @Column(name = "montant_payee", nullable = false)
    private Double montantPayee;

    public JournalCommandeFille() {
    }

    public JournalCommandeFille(Integer id, LigneCommande ligneCommande, Utilisateur utilisateur, Client client, Double montantTotal, Double montantPayee) {
        this.id = id;
        this.ligneCommande = ligneCommande;
        this.utilisateur = utilisateur;
        this.client = client;
        this.montantTotal = montantTotal;
        this.montantPayee = montantPayee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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