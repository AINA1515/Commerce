package mg.aina.commerce.fournisseur.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.fournisseur.dto.FournisseurDTO;
import mg.aina.commerce.fournisseur.entity.Fournisseur;
import mg.aina.commerce.fournisseur.repository.FournisseurRepository;

import java.util.List;

@Service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public List<FournisseurDTO> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public FournisseurDTO findById(Integer id) {
        return fournisseurRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public FournisseurDTO save(FournisseurDTO dto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setEmail(dto.getEmail());
        fournisseur.setTelephone(dto.getTelephone());
        fournisseur.setAdresse(dto.getAdresse());
        return toDTO(fournisseurRepository.save(fournisseur));
    }

    public FournisseurDTO update(Integer id, FournisseurDTO dto) {
        Fournisseur existing = fournisseurRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setEmail(dto.getEmail());
        existing.setTelephone(dto.getTelephone());
        existing.setAdresse(dto.getAdresse());
        return toDTO(fournisseurRepository.save(existing));
    }

    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);
    }

    private FournisseurDTO toDTO(Fournisseur fournisseur) {
        return new FournisseurDTO(
                fournisseur.getId(),
                fournisseur.getNom(),
                fournisseur.getPrenom(),
                fournisseur.getEmail(),
                fournisseur.getTelephone(),
                fournisseur.getAdresse()
        );
    }
}
