package mg.aina.commerce.remise.service;

import mg.aina.commerce.remise.dto.HistoriqueRemiseDTO;
import mg.aina.commerce.remise.entity.HistoriqueRemise;
import mg.aina.commerce.remise.entity.TypeChangementRemise;
import mg.aina.commerce.remise.repository.HistoriqueRemiseRepository;
import mg.aina.commerce.remise.repository.TypeChangementRemiseRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueRemiseService {
    private final HistoriqueRemiseRepository historiqueRemiseRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final TypeChangementRemiseRepository typeChangementRemiseRepository;

    public HistoriqueRemiseService(HistoriqueRemiseRepository historiqueRemiseRepository,
                                   UtilisateurRepository utilisateurRepository,
                                   TypeChangementRemiseRepository typeChangementRemiseRepository) {
        this.historiqueRemiseRepository = historiqueRemiseRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.typeChangementRemiseRepository = typeChangementRemiseRepository;
    }

    public List<HistoriqueRemiseDTO> findAll() {
        return historiqueRemiseRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public HistoriqueRemiseDTO findById(Integer id) {
        return historiqueRemiseRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public HistoriqueRemiseDTO save(HistoriqueRemiseDTO dto) {
        HistoriqueRemise historique = new HistoriqueRemise();
        historique.setPourcentage(dto.getPourcentage());
        historique.setDateRetour(dto.getDateRetour());
        historique.setDateFin(dto.getDateFin());
        historique.setDisponibilite(dto.getDisponibilite());
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        TypeChangementRemise typeChangement = typeChangementRemiseRepository.findById(dto.getIdTypeChangement()).orElse(null);
        historique.setUtilisateur(utilisateur);
        historique.setTypeChangement(typeChangement);
        return toDTO(historiqueRemiseRepository.save(historique));
    }

    public HistoriqueRemiseDTO update(Integer id, HistoriqueRemiseDTO dto) {
        HistoriqueRemise historique = historiqueRemiseRepository.findById(id).orElse(null);
        if (historique == null) {
            return null;
        }
        historique.setPourcentage(dto.getPourcentage());
        historique.setDateRetour(dto.getDateRetour());
        historique.setDateFin(dto.getDateFin());
        historique.setDisponibilite(dto.getDisponibilite());
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        TypeChangementRemise typeChangement = typeChangementRemiseRepository.findById(dto.getIdTypeChangement()).orElse(null);
        historique.setUtilisateur(utilisateur);
        historique.setTypeChangement(typeChangement);
        return toDTO(historiqueRemiseRepository.save(historique));
    }

    public void delete(Integer id) {
        historiqueRemiseRepository.deleteById(id);
    }

    private HistoriqueRemiseDTO toDTO(HistoriqueRemise historique) {
        return new HistoriqueRemiseDTO(
                historique.getId(),
                historique.getUtilisateur() != null ? historique.getUtilisateur().getId() : null,
                historique.getUtilisateur() != null ? historique.getUtilisateur().getNom() + " " + historique.getUtilisateur().getPrenom() : null,
                historique.getPourcentage(),
                historique.getDateRetour(),
                historique.getDateFin(),
                historique.getDisponibilite(),
                historique.getTypeChangement() != null ? historique.getTypeChangement().getId() : null,
                historique.getTypeChangement() != null ? historique.getTypeChangement().getNom() : null
        );
    }
}