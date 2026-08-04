package mg.aina.commerce.produit.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.produit.dto.TypeProduitDTO;
import mg.aina.commerce.produit.entity.TypeProduit;
import mg.aina.commerce.produit.repository.TypeProduitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeProduitService {
    private final TypeProduitRepository typeProduitRepository;

    public TypeProduitService(TypeProduitRepository typeProduitRepository) {
        this.typeProduitRepository = typeProduitRepository;
    }

    public List<TypeProduitDTO> findAll() {
        return typeProduitRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public TypeProduitDTO findById(Integer id) {
        return typeProduitRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public TypeProduitDTO save(TypeProduitDTO dto) {
        TypeProduit typeProduit = new TypeProduit();
        typeProduit.setNom(dto.getNom());
        return toDTO(typeProduitRepository.save(typeProduit));
    }

    public TypeProduitDTO update(Integer id, TypeProduitDTO dto) {
        TypeProduit existing = typeProduitRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        return toDTO(typeProduitRepository.save(existing));
    }

    public void delete(Integer id) {
        typeProduitRepository.deleteById(id);
    }

    private TypeProduitDTO toDTO(TypeProduit typeProduit) {
        return new TypeProduitDTO(
                typeProduit.getId(),
                typeProduit.getNom()
        );
    }
}
