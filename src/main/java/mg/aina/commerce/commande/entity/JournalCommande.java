package mg.aina.commerce.commande.entity;

import jakarta.persistence.*;
import mg.aina.commerce.client.entity.Client;
import mg.aina.commerce.utilisateur.entity.Utilisateur;

@Entity
@Table(name = "journal_commande")
public class JournalCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande commande;

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

    public JournalCommande() {
    }

    public JournalCommande(Integer id, Commande commande, Utilisateur utilisateur, Client client, Double montantTotal, Double montantPayee) {
        this.id = id;
        this.commande = commande;
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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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