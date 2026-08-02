package mg.aina.commerce.produit.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.produit.entity.TypeProduit;
import mg.aina.commerce.produit.repository.TypeProduitRepository;

import java.util.List;

@Service
public class TypeProduitService {
    private final TypeProduitRepository typeProduitRepository;

    public TypeProduitService(TypeProduitRepository typeProduitRepository) {
        this.typeProduitRepository = typeProduitRepository;
    }

    public List<TypeProduit> findAll() {
        return typeProduitRepository.findAll();
    }

    public TypeProduit findById(Integer id) {
        return typeProduitRepository.findById(id).orElse(null);
    }

    public TypeProduit save(TypeProduit typeProduit) {
        return typeProduitRepository.save(typeProduit);
    }

    public TypeProduit update(Integer id, TypeProduit typeProduit) {
        TypeProduit existing = typeProduitRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(typeProduit.getNom());
        return typeProduitRepository.save(existing);
    }

    public void delete(Integer id) {
        typeProduitRepository.deleteById(id);
    }
}