package mg.aina.commerce.produit.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.produit.dto.ProduitDTO;
import mg.aina.commerce.produit.entity.Produit;
import mg.aina.commerce.produit.entity.TypeProduit;
import mg.aina.commerce.produit.repository.ProduitRepository;
import mg.aina.commerce.produit.repository.TypeProduitRepository;

import java.util.List;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;
    private final TypeProduitRepository typeProduitRepository;

    public ProduitService(ProduitRepository produitRepository, TypeProduitRepository typeProduitRepository) {
        this.produitRepository = produitRepository;
        this.typeProduitRepository = typeProduitRepository;
    }

    public List<ProduitDTO> findAll() {
        return produitRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ProduitDTO findById(Integer id) {
        return produitRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ProduitDTO save(ProduitDTO dto) {
        Produit produit = new Produit();
        produit.setNom(dto.getNom());
        produit.setDescription(dto.getDescription());
        produit.setStockMinimum(dto.getStockMinimum());
        TypeProduit typeProduit = typeProduitRepository.findById(dto.getIdTypeProduit()).orElse(null);

        if (typeProduit == null) {
            return null;
        }
        
        produit.setTypeProduit(typeProduit);
        return toDTO(produitRepository.save(produit));
    }

    public ProduitDTO update(Integer id, ProduitDTO dto) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null) {
            return null;
        }
        produit.setNom(dto.getNom());
        produit.setDescription(dto.getDescription());
        produit.setStockMinimum(dto.getStockMinimum());
        TypeProduit typeProduit = typeProduitRepository.findById(dto.getIdTypeProduit()).orElse(null);
        produit.setTypeProduit(typeProduit);
        return toDTO(produitRepository.save(produit));
    }

    public void delete(Integer id) {
        produitRepository.deleteById(id);
    }

    private ProduitDTO toDTO(Produit produit) {
        return new ProduitDTO(
                produit.getId(),
                produit.getNom(),
                produit.getDescription(),
                produit.getTypeProduit() != null ? produit.getTypeProduit().getId() : null,
                produit.getTypeProduit() != null ? produit.getTypeProduit().getNom() : null,
                produit.getStockMinimum(),
                produit.getDateCreation());
    }
}