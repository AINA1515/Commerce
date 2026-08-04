package mg.aina.commerce.fournisseur.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.fournisseur.dto.TypeTransactionFournisseurDTO;
import mg.aina.commerce.fournisseur.entity.TypeTransactionFournisseur;
import mg.aina.commerce.fournisseur.repository.TypeTransactionFournisseurRepository;

import java.util.List;

@Service
public class TypeTransactionFournisseurService {
    private final TypeTransactionFournisseurRepository typeTransactionFournisseurRepository;

    public TypeTransactionFournisseurService(TypeTransactionFournisseurRepository typeTransactionFournisseurRepository) {
        this.typeTransactionFournisseurRepository = typeTransactionFournisseurRepository;
    }

    public List<TypeTransactionFournisseurDTO> findAll() {
        return typeTransactionFournisseurRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public TypeTransactionFournisseurDTO findById(Integer id) {
        return typeTransactionFournisseurRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public TypeTransactionFournisseurDTO save(TypeTransactionFournisseurDTO dto) {
        TypeTransactionFournisseur typeTransactionFournisseur = new TypeTransactionFournisseur();
        typeTransactionFournisseur.setNom(dto.getNom());
        return toDTO(typeTransactionFournisseurRepository.save(typeTransactionFournisseur));
    }

    public TypeTransactionFournisseurDTO update(Integer id, TypeTransactionFournisseurDTO dto) {
        TypeTransactionFournisseur existing = typeTransactionFournisseurRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        return toDTO(typeTransactionFournisseurRepository.save(existing));
    }

    public void delete(Integer id) {
        typeTransactionFournisseurRepository.deleteById(id);
    }

    private TypeTransactionFournisseurDTO toDTO(TypeTransactionFournisseur typeTransactionFournisseur) {
        return new TypeTransactionFournisseurDTO(
                typeTransactionFournisseur.getId(),
                typeTransactionFournisseur.getNom()
        );
    }
}
