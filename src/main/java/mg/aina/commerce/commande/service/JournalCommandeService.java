package mg.aina.commerce.commande.service;

import mg.aina.commerce.client.entity.Client;
import mg.aina.commerce.client.repository.ClientRepository;
import mg.aina.commerce.commande.dto.JournalCommandeDTO;
import mg.aina.commerce.commande.entity.Commande;
import mg.aina.commerce.commande.entity.JournalCommande;
import mg.aina.commerce.commande.repository.CommandeRepository;
import mg.aina.commerce.commande.repository.JournalCommandeRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalCommandeService {
    private final JournalCommandeRepository journalCommandeRepository;
    private final CommandeRepository commandeRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ClientRepository clientRepository;

    public JournalCommandeService(JournalCommandeRepository journalCommandeRepository,
                                  CommandeRepository commandeRepository,
                                  UtilisateurRepository utilisateurRepository,
                                  ClientRepository clientRepository) {
        this.journalCommandeRepository = journalCommandeRepository;
        this.commandeRepository = commandeRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.clientRepository = clientRepository;
    }

    public List<JournalCommandeDTO> findAll() {
        return journalCommandeRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public JournalCommandeDTO findById(Integer id) {
        return journalCommandeRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public JournalCommandeDTO save(JournalCommandeDTO dto) {
        JournalCommande journal = new JournalCommande();
        journal.setMontantTotal(dto.getMontantTotal());
        journal.setMontantPayee(dto.getMontantPayee());
        Commande commande = commandeRepository.findById(dto.getIdCommande()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Client client = clientRepository.findById(dto.getIdClient()).orElse(null);
        journal.setCommande(commande);
        journal.setUtilisateur(utilisateur);
        journal.setClient(client);
        return toDTO(journalCommandeRepository.save(journal));
    }

    public JournalCommandeDTO update(Integer id, JournalCommandeDTO dto) {
        JournalCommande journal = journalCommandeRepository.findById(id).orElse(null);
        if (journal == null) {
            return null;
        }
        journal.setMontantTotal(dto.getMontantTotal());
        journal.setMontantPayee(dto.getMontantPayee());
        Commande commande = commandeRepository.findById(dto.getIdCommande()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Client client = clientRepository.findById(dto.getIdClient()).orElse(null);
        journal.setCommande(commande);
        journal.setUtilisateur(utilisateur);
        journal.setClient(client);
        return toDTO(journalCommandeRepository.save(journal));
    }

    public void delete(Integer id) {
        journalCommandeRepository.deleteById(id);
    }

    private JournalCommandeDTO toDTO(JournalCommande journal) {
        return new JournalCommandeDTO(
                journal.getId(),
                journal.getCommande() != null ? journal.getCommande().getId() : null,
                journal.getUtilisateur() != null ? journal.getUtilisateur().getId() : null,
                journal.getUtilisateur() != null ? journal.getUtilisateur().getNom() + " " + journal.getUtilisateur().getPrenom() : null,
                journal.getClient() != null ? journal.getClient().getId() : null,
                journal.getClient() != null ? journal.getClient().getNom() + " " + journal.getClient().getPrenom() : null,
                journal.getMontantTotal(),
                journal.getMontantPayee()
        );
    }
}