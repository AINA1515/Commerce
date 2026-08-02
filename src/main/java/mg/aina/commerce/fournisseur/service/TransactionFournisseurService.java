package mg.aina.commerce.fournisseur.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.fournisseur.dto.TransactionFournisseurDTO;
import mg.aina.commerce.fournisseur.entity.TransactionFournisseur;
import mg.aina.commerce.fournisseur.entity.TypeTransactionFournisseur;
import mg.aina.commerce.fournisseur.repository.TransactionFournisseurRepository;
import mg.aina.commerce.fournisseur.repository.TypeTransactionFournisseurRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionFournisseurService {
    private final TransactionFournisseurRepository transactionFournisseurRepository;
    private final TypeTransactionFournisseurRepository typeTransactionFournisseurRepository;
    private final UtilisateurRepository utilisateurRepository;

    public TransactionFournisseurService(TransactionFournisseurRepository transactionFournisseurRepository,
                                         TypeTransactionFournisseurRepository typeTransactionFournisseurRepository,
                                         UtilisateurRepository utilisateurRepository) {
        this.transactionFournisseurRepository = transactionFournisseurRepository;
        this.typeTransactionFournisseurRepository = typeTransactionFournisseurRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<TransactionFournisseurDTO> findAll() {
        return transactionFournisseurRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TransactionFournisseurDTO findById(Integer id) {
        return transactionFournisseurRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public TransactionFournisseurDTO save(TransactionFournisseurDTO dto) {
        TransactionFournisseur transaction = new TransactionFournisseur();
        transaction.setMontantTotal(dto.getMontantTotal());
        TypeTransactionFournisseur type = typeTransactionFournisseurRepository.findById(dto.getIdTypeTransactionFournisseur()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        transaction.setTypeTransactionFournisseur(type);
        transaction.setUtilisateur(utilisateur);
        return toDTO(transactionFournisseurRepository.save(transaction));
    }

    public TransactionFournisseurDTO update(Integer id, TransactionFournisseurDTO dto) {
        TransactionFournisseur transaction = transactionFournisseurRepository.findById(id).orElse(null);
        if (transaction == null) {
            return null;
        }
        transaction.setMontantTotal(dto.getMontantTotal());
        TypeTransactionFournisseur type = typeTransactionFournisseurRepository.findById(dto.getIdTypeTransactionFournisseur()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        transaction.setTypeTransactionFournisseur(type);
        transaction.setUtilisateur(utilisateur);
        return toDTO(transactionFournisseurRepository.save(transaction));
    }

    public void delete(Integer id) {
        transactionFournisseurRepository.deleteById(id);
    }

    private TransactionFournisseurDTO toDTO(TransactionFournisseur transaction) {
        return new TransactionFournisseurDTO(
                transaction.getId(),
                transaction.getTypeTransactionFournisseur() != null ? transaction.getTypeTransactionFournisseur().getId() : null,
                transaction.getTypeTransactionFournisseur() != null ? transaction.getTypeTransactionFournisseur().getNom() : null,
                transaction.getUtilisateur() != null ? transaction.getUtilisateur().getId() : null,
                transaction.getUtilisateur() != null ? transaction.getUtilisateur().getNom() + " " + transaction.getUtilisateur().getPrenom() : null,
                transaction.getMontantTotal(),
                transaction.getDateModification()
        );
    }
}