package mg.aina.commerce.commande.service;

import mg.aina.commerce.client.entity.Client;
import mg.aina.commerce.client.repository.ClientRepository;
import mg.aina.commerce.commande.dto.CommandeDTO;
import mg.aina.commerce.commande.entity.Commande;
import mg.aina.commerce.commande.entity.TypeTransactionCommande;
import mg.aina.commerce.commande.repository.CommandeRepository;
import mg.aina.commerce.commande.repository.TypeTransactionCommandeRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final TypeTransactionCommandeRepository typeTransactionCommandeRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ClientRepository clientRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           TypeTransactionCommandeRepository typeTransactionCommandeRepository,
                           UtilisateurRepository utilisateurRepository,
                           ClientRepository clientRepository) {
        this.commandeRepository = commandeRepository;
        this.typeTransactionCommandeRepository = typeTransactionCommandeRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.clientRepository = clientRepository;
    }

    public List<CommandeDTO> findAll() {
        return commandeRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public CommandeDTO findById(Integer id) {
        return commandeRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public CommandeDTO save(CommandeDTO dto) {
        Commande commande = new Commande();
        commande.setPrixTotal(dto.getPrixTotal());
        commande.setMontantPayee(dto.getMontantPayee());
        TypeTransactionCommande type = typeTransactionCommandeRepository.findById(dto.getIdTypeTransactionCommande()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Client client = clientRepository.findById(dto.getIdClient()).orElse(null);
        commande.setTypeTransactionCommande(type);
        commande.setUtilisateur(utilisateur);
        commande.setClient(client);
        return toDTO(commandeRepository.save(commande));
    }

    public CommandeDTO update(Integer id, CommandeDTO dto) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if (commande == null) {
            return null;
        }
        commande.setPrixTotal(dto.getPrixTotal());
        commande.setMontantPayee(dto.getMontantPayee());
        TypeTransactionCommande type = typeTransactionCommandeRepository.findById(dto.getIdTypeTransactionCommande()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Client client = clientRepository.findById(dto.getIdClient()).orElse(null);
        commande.setTypeTransactionCommande(type);
        commande.setUtilisateur(utilisateur);
        commande.setClient(client);
        return toDTO(commandeRepository.save(commande));
    }

    public void delete(Integer id) {
        commandeRepository.deleteById(id);
    }

    private CommandeDTO toDTO(Commande commande) {
        return new CommandeDTO(
                commande.getId(),
                commande.getPrixTotal(),
                commande.getTypeTransactionCommande() != null ? commande.getTypeTransactionCommande().getId() : null,
                commande.getTypeTransactionCommande() != null ? commande.getTypeTransactionCommande().getNom() : null,
                commande.getUtilisateur() != null ? commande.getUtilisateur().getId() : null,
                commande.getUtilisateur() != null ? commande.getUtilisateur().getNom() + " " + commande.getUtilisateur().getPrenom() : null,
                commande.getClient() != null ? commande.getClient().getId() : null,
                commande.getClient() != null ? commande.getClient().getNom() + " " + commande.getClient().getPrenom() : null,
                commande.getMontantPayee(),
                commande.getDateModification()
        );
    }
}