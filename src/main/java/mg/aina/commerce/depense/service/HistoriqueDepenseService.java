package mg.aina.commerce.depense.service;

import mg.aina.commerce.depense.dto.HistoriqueDepenseDTO;
import mg.aina.commerce.depense.entity.HistoriqueDepense;
import mg.aina.commerce.depense.entity.TypeDepense;
import mg.aina.commerce.depense.repository.HistoriqueDepenseRepository;
import mg.aina.commerce.depense.repository.TypeDepenseRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueDepenseService {
    private final HistoriqueDepenseRepository repository;
    private final UtilisateurRepository utilisateurRepository;
    private final TypeDepenseRepository typeDepenseRepository;

    public HistoriqueDepenseService(HistoriqueDepenseRepository repository,
                                    UtilisateurRepository utilisateurRepository,
                                    TypeDepenseRepository typeDepenseRepository) {
        this.repository = repository;
        this.utilisateurRepository = utilisateurRepository;
        this.typeDepenseRepository = typeDepenseRepository;
    }

    public List<HistoriqueDepenseDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public HistoriqueDepenseDTO findById(Integer id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    public HistoriqueDepenseDTO save(HistoriqueDepenseDTO dto) {
        HistoriqueDepense entity = new HistoriqueDepense();
        entity.setMontant(dto.getMontant());
        entity.setDescription(dto.getDescription());
        entity.setUtilisateur(utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null));
        entity.setTypeDepense(typeDepenseRepository.findById(dto.getIdTypeDepense()).orElse(null));
        return toDTO(repository.save(entity));
    }

    public HistoriqueDepenseDTO update(Integer id, HistoriqueDepenseDTO dto) {
        HistoriqueDepense entity = repository.findById(id).orElse(null);
        if (entity == null) { return null; }
        entity.setMontant(dto.getMontant());
        entity.setDescription(dto.getDescription());
        entity.setUtilisateur(utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null));
        entity.setTypeDepense(typeDepenseRepository.findById(dto.getIdTypeDepense()).orElse(null));
        return toDTO(repository.save(entity));
    }

    public void delete(Integer id) { repository.deleteById(id); }

    private HistoriqueDepenseDTO toDTO(HistoriqueDepense entity) {
        return new HistoriqueDepenseDTO(
                entity.getId(),
                entity.getUtilisateur() != null ? entity.getUtilisateur().getId() : null,
                entity.getUtilisateur() != null ? entity.getUtilisateur().getNom() + " " + entity.getUtilisateur().getPrenom() : null,
                entity.getTypeDepense() != null ? entity.getTypeDepense().getId() : null,
                entity.getTypeDepense() != null ? entity.getTypeDepense().getNom() : null,
                entity.getMontant(),
                entity.getDescription(),
                entity.getDateCreation()
        );
    }
}
