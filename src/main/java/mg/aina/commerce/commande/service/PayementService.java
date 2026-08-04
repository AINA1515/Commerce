package mg.aina.commerce.commande.service;

import mg.aina.commerce.commande.dto.PayementDTO;
import mg.aina.commerce.commande.entity.LigneCommande;
import mg.aina.commerce.commande.entity.Payement;
import mg.aina.commerce.commande.entity.TypePayement;
import mg.aina.commerce.commande.repository.LigneCommandeRepository;
import mg.aina.commerce.commande.repository.PayementRepository;
import mg.aina.commerce.commande.repository.TypePayementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayementService {
    private final PayementRepository payementRepository;
    private final LigneCommandeRepository ligneCommandeRepository;
    private final TypePayementRepository typePayementRepository;

    public PayementService(PayementRepository payementRepository,
                           LigneCommandeRepository ligneCommandeRepository,
                           TypePayementRepository typePayementRepository) {
        this.payementRepository = payementRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.typePayementRepository = typePayementRepository;
    }

    public List<PayementDTO> findAll() {
        return payementRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public PayementDTO findById(Integer id) {
        return payementRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<PayementDTO> findByLigneCommandeId(Integer ligneCommandeId) {
        return payementRepository.findByLigneCommandeId(ligneCommandeId).stream()
                .map(this::toDTO)
                .toList();
    }

    public PayementDTO save(PayementDTO dto) {
        Payement payement = new Payement();
        payement.setMontant(dto.getMontant());
        LigneCommande ligneCommande = ligneCommandeRepository.findById(dto.getIdLigneCommande()).orElse(null);
        TypePayement typePayement = typePayementRepository.findById(dto.getIdTypePayement()).orElse(null);
        payement.setLigneCommande(ligneCommande);
        payement.setTypePayement(typePayement);
        return toDTO(payementRepository.save(payement));
    }

    public PayementDTO update(Integer id, PayementDTO dto) {
        Payement payement = payementRepository.findById(id).orElse(null);
        if (payement == null) {
            return null;
        }
        payement.setMontant(dto.getMontant());
        LigneCommande ligneCommande = ligneCommandeRepository.findById(dto.getIdLigneCommande()).orElse(null);
        TypePayement typePayement = typePayementRepository.findById(dto.getIdTypePayement()).orElse(null);
        payement.setLigneCommande(ligneCommande);
        payement.setTypePayement(typePayement);
        return toDTO(payementRepository.save(payement));
    }

    public void delete(Integer id) {
        payementRepository.deleteById(id);
    }

    private PayementDTO toDTO(Payement payement) {
        return new PayementDTO(
                payement.getId(),
                payement.getLigneCommande() != null ? payement.getLigneCommande().getId() : null,
                payement.getTypePayement() != null ? payement.getTypePayement().getId() : null,
                payement.getTypePayement() != null ? payement.getTypePayement().getNom() : null,
                payement.getMontant(),
                payement.getDateModification()
        );
    }
}