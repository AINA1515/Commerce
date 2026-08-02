package mg.aina.commerce.fournisseur.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.fournisseur.dto.TransactionFournisseurLigneDTO;
import mg.aina.commerce.fournisseur.entity.Fournisseur;
import mg.aina.commerce.fournisseur.entity.TransactionFournisseur;
import mg.aina.commerce.fournisseur.entity.TransactionFournisseurLigne;
import mg.aina.commerce.fournisseur.repository.FournisseurRepository;
import mg.aina.commerce.fournisseur.repository.TransactionFournisseurLigneRepository;
import mg.aina.commerce.fournisseur.repository.TransactionFournisseurRepository;
import mg.aina.commerce.produit.entity.Produit;
import mg.aina.commerce.produit.repository.ProduitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionFournisseurLigneService {
    private final TransactionFournisseurLigneRepository ligneRepository;
    private final FournisseurRepository fournisseurRepository;
    private final TransactionFournisseurRepository transactionRepository;
    private final ProduitRepository produitRepository;

    public TransactionFournisseurLigneService(TransactionFournisseurLigneRepository ligneRepository,
                                              FournisseurRepository fournisseurRepository,
                                              TransactionFournisseurRepository transactionRepository,
                                              ProduitRepository produitRepository) {
        this.ligneRepository = ligneRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.transactionRepository = transactionRepository;
        this.produitRepository = produitRepository;
    }

    public List<TransactionFournisseurLigneDTO> findAll() {
        return ligneRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TransactionFournisseurLigneDTO findById(Integer id) {
        return ligneRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<TransactionFournisseurLigneDTO> findByFournisseurId(Integer fournisseurId) {
        return ligneRepository.findByFournisseurId(fournisseurId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TransactionFournisseurLigneDTO save(TransactionFournisseurLigneDTO dto) {
        TransactionFournisseurLigne ligne = new TransactionFournisseurLigne();
        ligne.setQuantite(dto.getQuantite());
        ligne.setMontant(dto.getMontant());
        Fournisseur fournisseur = fournisseurRepository.findById(dto.getIdFournisseur()).orElse(null);
        TransactionFournisseur transaction = transactionRepository.findById(dto.getIdTransactionFournisseur()).orElse(null);
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        ligne.setFournisseur(fournisseur);
        ligne.setTransactionFournisseur(transaction);
        ligne.setProduit(produit);
        return toDTO(ligneRepository.save(ligne));
    }

    public TransactionFournisseurLigneDTO update(Integer id, TransactionFournisseurLigneDTO dto) {
        TransactionFournisseurLigne ligne = ligneRepository.findById(id).orElse(null);
        if (ligne == null) {
            return null;
        }
        ligne.setQuantite(dto.getQuantite());
        ligne.setMontant(dto.getMontant());
        Fournisseur fournisseur = fournisseurRepository.findById(dto.getIdFournisseur()).orElse(null);
        TransactionFournisseur transaction = transactionRepository.findById(dto.getIdTransactionFournisseur()).orElse(null);
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        ligne.setFournisseur(fournisseur);
        ligne.setTransactionFournisseur(transaction);
        ligne.setProduit(produit);
        return toDTO(ligneRepository.save(ligne));
    }

    public void delete(Integer id) {
        ligneRepository.deleteById(id);
    }

    private TransactionFournisseurLigneDTO toDTO(TransactionFournisseurLigne ligne) {
        return new TransactionFournisseurLigneDTO(
                ligne.getId(),
                ligne.getFournisseur() != null ? ligne.getFournisseur().getId() : null,
                ligne.getFournisseur() != null ? ligne.getFournisseur().getNom() + " " + ligne.getFournisseur().getPrenom() : null,
                ligne.getTransactionFournisseur() != null ? ligne.getTransactionFournisseur().getId() : null,
                ligne.getProduit() != null ? ligne.getProduit().getId() : null,
                ligne.getProduit() != null ? ligne.getProduit().getNom() : null,
                ligne.getQuantite(),
                ligne.getMontant(),
                ligne.getDateModification()
        );
    }
}