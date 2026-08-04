package mg.aina.commerce.produit.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.produit.dto.TypeTransationStockDTO;
import mg.aina.commerce.produit.entity.TypeTransationStock;
import mg.aina.commerce.produit.repository.TypeTransationStockRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeTransationStockService {
    private final TypeTransationStockRepository typeTransationStockRepository;

    public TypeTransationStockService(TypeTransationStockRepository typeTransationStockRepository) {
        this.typeTransationStockRepository = typeTransationStockRepository;
    }

    public List<TypeTransationStockDTO> findAll() {
        return typeTransationStockRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public TypeTransationStockDTO findById(Integer id) {
        return typeTransationStockRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public TypeTransationStockDTO save(TypeTransationStockDTO dto) {
        TypeTransationStock typeTransationStock = new TypeTransationStock();
        typeTransationStock.setNom(dto.getNom());
        return toDTO(typeTransationStockRepository.save(typeTransationStock));
    }

    public TypeTransationStockDTO update(Integer id, TypeTransationStockDTO dto) {
        TypeTransationStock existing = typeTransationStockRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        return toDTO(typeTransationStockRepository.save(existing));
    }

    public void delete(Integer id) {
        typeTransationStockRepository.deleteById(id);
    }

    private TypeTransationStockDTO toDTO(TypeTransationStock typeTransationStock) {
        return new TypeTransationStockDTO(
                typeTransationStock.getId(),
                typeTransationStock.getNom()
        );
    }
}
