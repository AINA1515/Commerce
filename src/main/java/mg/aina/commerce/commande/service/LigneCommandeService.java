package mg.aina.commerce.commande.service;

import mg.aina.commerce.commande.dto.LigneCommandeDTO;
import mg.aina.commerce.commande.entity.Commande;
import mg.aina.commerce.commande.entity.LigneCommande;
import mg.aina.commerce.commande.entity.StatusLigneCommande;
import mg.aina.commerce.commande.repository.CommandeRepository;
import mg.aina.commerce.commande.repository.LigneCommandeRepository;
import mg.aina.commerce.commande.repository.StatusLigneCommandeRepository;
import mg.aina.commerce.produit.entity.Produit;
import mg.aina.commerce.produit.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeService {
    private final LigneCommandeRepository ligneCommandeRepository;
    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final StatusLigneCommandeRepository statusLigneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository,
                                CommandeRepository commandeRepository,
                                ProduitRepository produitRepository,
                                StatusLigneCommandeRepository statusLigneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
        this.statusLigneCommandeRepository = statusLigneCommandeRepository;
    }

    public List<LigneCommandeDTO> findAll() {
        return ligneCommandeRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public LigneCommandeDTO findById(Integer id) {
        return ligneCommandeRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<LigneCommandeDTO> findByCommandeId(Integer commandeId) {
        return ligneCommandeRepository.findByCommandeId(commandeId).stream()
                .map(this::toDTO)
                .toList();
    }

    public LigneCommandeDTO save(LigneCommandeDTO dto) {
        LigneCommande ligne = new LigneCommande();
        ligne.setQuantite(dto.getQuantite());
        ligne.setMontantPayee(dto.getMontantPayee());
        ligne.setPrix(dto.getPrix());
        Commande commande = commandeRepository.findById(dto.getIdCommande()).orElse(null);
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        StatusLigneCommande status = statusLigneCommandeRepository.findById(dto.getIdStatusLigneCommande()).orElse(null);
        ligne.setCommande(commande);
        ligne.setProduit(produit);
        ligne.setStatusLigneCommande(status);
        return toDTO(ligneCommandeRepository.save(ligne));
    }

    public LigneCommandeDTO update(Integer id, LigneCommandeDTO dto) {
        LigneCommande ligne = ligneCommandeRepository.findById(id).orElse(null);
        if (ligne == null) {
            return null;
        }
        ligne.setQuantite(dto.getQuantite());
        ligne.setMontantPayee(dto.getMontantPayee());
        ligne.setPrix(dto.getPrix());
        Commande commande = commandeRepository.findById(dto.getIdCommande()).orElse(null);
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        StatusLigneCommande status = statusLigneCommandeRepository.findById(dto.getIdStatusLigneCommande()).orElse(null);
        ligne.setCommande(commande);
        ligne.setProduit(produit);
        ligne.setStatusLigneCommande(status);
        return toDTO(ligneCommandeRepository.save(ligne));
    }

    public void delete(Integer id) {
        ligneCommandeRepository.deleteById(id);
    }

    private LigneCommandeDTO toDTO(LigneCommande ligne) {
        return new LigneCommandeDTO(
                ligne.getId(),
                ligne.getCommande() != null ? ligne.getCommande().getId() : null,
                ligne.getProduit() != null ? ligne.getProduit().getId() : null,
                ligne.getProduit() != null ? ligne.getProduit().getNom() : null,
                ligne.getQuantite(),
                ligne.getStatusLigneCommande() != null ? ligne.getStatusLigneCommande().getId() : null,
                ligne.getStatusLigneCommande() != null ? ligne.getStatusLigneCommande().getNom() : null,
                ligne.getMontantPayee(),
                ligne.getDateModification(),
                ligne.getPrix()
        );
    }
}