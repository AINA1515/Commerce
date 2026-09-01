package mg.aina.commerce.produit.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.produit.dto.JournalStockDTO;
import mg.aina.commerce.produit.entity.JournalStock;
import mg.aina.commerce.produit.entity.Produit;
import mg.aina.commerce.produit.entity.TypeTransactionStock;
import mg.aina.commerce.produit.repository.JournalStockRepository;
import mg.aina.commerce.produit.repository.ProduitRepository;
import mg.aina.commerce.produit.repository.TypeTransactionStockRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;

import java.util.List;

@Service
public class JournalStockService {
    private final JournalStockRepository journalStockRepository;
    private final ProduitRepository produitRepository;
    private final TypeTransactionStockRepository typeTransactionStockRepository;
    private final UtilisateurRepository utilisateurRepository;

    public JournalStockService(JournalStockRepository journalStockRepository,
            ProduitRepository produitRepository,
            TypeTransactionStockRepository typeTransactionStockRepository,
            UtilisateurRepository utilisateurRepository) {
        this.journalStockRepository = journalStockRepository;
        this.produitRepository = produitRepository;
        this.typeTransactionStockRepository = typeTransactionStockRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<JournalStockDTO> findAll() {
        return journalStockRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public JournalStockDTO findById(Integer id) {
        return journalStockRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<JournalStockDTO> findByProduitId(Integer produitId) {
        return journalStockRepository.findByProduitId(produitId).stream()
                .map(this::toDTO)
                .toList();
    }

    public JournalStockDTO save(JournalStockDTO dto) {
        JournalStock journalStock = new JournalStock();
        journalStock.setQuantite(dto.getQuantite());
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        if(produit == null){
            return null;
        }
        TypeTransactionStock typeTransactionStock = typeTransactionStockRepository.findByNom(dto.getNomTypeTransactionStock())
                .orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        journalStock.setProduit(produit);
        journalStock.setTypeTransactionStock(typeTransactionStock);
        journalStock.setUtilisateur(utilisateur);
        return toDTO(journalStockRepository.save(journalStock));
    }

    public JournalStockDTO update(Integer id, JournalStockDTO dto) {
        JournalStock journalStock = journalStockRepository.findById(id).orElse(null);
        if (journalStock == null) {
            return null;
        }
        journalStock.setQuantite(dto.getQuantite());
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        TypeTransactionStock typeTransactionStock = typeTransactionStockRepository.findByNom(dto.getNomTypeTransactionStock()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        journalStock.setProduit(produit);
        journalStock.setTypeTransactionStock(typeTransactionStock);
        journalStock.setUtilisateur(utilisateur);
        return toDTO(journalStockRepository.save(journalStock));
    }

    public void delete(Integer id) {
        journalStockRepository.deleteById(id);
    }

    private JournalStockDTO toDTO(JournalStock journalStock) {
        return new JournalStockDTO(
                journalStock.getProduit() != null ? journalStock.getProduit().getId() : null,
                journalStock.getProduit() != null ? journalStock.getProduit().getNom() : null,
                journalStock.getTypeTransactionStock() != null ? journalStock.getTypeTransactionStock().getNom() : null,
                journalStock.getQuantite(),
                journalStock.getUtilisateur() != null ? journalStock.getUtilisateur().getId() : null,
                journalStock.getUtilisateur() != null
                        ? journalStock.getUtilisateur().getNom() + " " + journalStock.getUtilisateur().getPrenom()
                        : null,
                journalStock.getDateModification());
    }
}