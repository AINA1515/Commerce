package mg.aina.commerce.commande.service;

import mg.aina.commerce.client.entity.Client;
import mg.aina.commerce.client.repository.ClientRepository;
import mg.aina.commerce.commande.dto.JournalCommandeFilleDTO;
import mg.aina.commerce.commande.entity.JournalCommandeFille;
import mg.aina.commerce.commande.entity.LigneCommande;
import mg.aina.commerce.commande.repository.JournalCommandeFilleRepository;
import mg.aina.commerce.commande.repository.LigneCommandeRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalCommandeFilleService {
    private final JournalCommandeFilleRepository journalFilleRepository;
    private final LigneCommandeRepository ligneCommandeRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ClientRepository clientRepository;

    public JournalCommandeFilleService(JournalCommandeFilleRepository journalFilleRepository,
                                       LigneCommandeRepository ligneCommandeRepository,
                                       UtilisateurRepository utilisateurRepository,
                                       ClientRepository clientRepository) {
        this.journalFilleRepository = journalFilleRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.clientRepository = clientRepository;
    }

    public List<JournalCommandeFilleDTO> findAll() {
        return journalFilleRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public JournalCommandeFilleDTO findById(Integer id) {
        return journalFilleRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public JournalCommandeFilleDTO save(JournalCommandeFilleDTO dto) {
        JournalCommandeFille journal = new JournalCommandeFille();
        journal.setMontantTotal(dto.getMontantTotal());
        journal.setMontantPayee(dto.getMontantPayee());
        LigneCommande ligneCommande = ligneCommandeRepository.findById(dto.getIdLigneCommande()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Client client = clientRepository.findById(dto.getIdClient()).orElse(null);
        journal.setLigneCommande(ligneCommande);
        journal.setUtilisateur(utilisateur);
        journal.setClient(client);
        return toDTO(journalFilleRepository.save(journal));
    }

    public JournalCommandeFilleDTO update(Integer id, JournalCommandeFilleDTO dto) {
        JournalCommandeFille journal = journalFilleRepository.findById(id).orElse(null);
        if (journal == null) {
            return null;
        }
        journal.setMontantTotal(dto.getMontantTotal());
        journal.setMontantPayee(dto.getMontantPayee());
        LigneCommande ligneCommande = ligneCommandeRepository.findById(dto.getIdLigneCommande()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Client client = clientRepository.findById(dto.getIdClient()).orElse(null);
        journal.setLigneCommande(ligneCommande);
        journal.setUtilisateur(utilisateur);
        journal.setClient(client);
        return toDTO(journalFilleRepository.save(journal));
    }

    public void delete(Integer id) {
        journalFilleRepository.deleteById(id);
    }

    private JournalCommandeFilleDTO toDTO(JournalCommandeFille journal) {
        return new JournalCommandeFilleDTO(
                journal.getId(),
                journal.getLigneCommande() != null ? journal.getLigneCommande().getId() : null,
                journal.getUtilisateur() != null ? journal.getUtilisateur().getId() : null,
                journal.getUtilisateur() != null ? journal.getUtilisateur().getNom() + " " + journal.getUtilisateur().getPrenom() : null,
                journal.getClient() != null ? journal.getClient().getId() : null,
                journal.getClient() != null ? journal.getClient().getNom() + " " + journal.getClient().getPrenom() : null,
                journal.getMontantTotal(),
                journal.getMontantPayee()
        );
    }
}