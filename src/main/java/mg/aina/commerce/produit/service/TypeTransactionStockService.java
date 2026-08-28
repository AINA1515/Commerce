package mg.aina.commerce.produit.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.produit.dto.TypeTransactionStockDTO;
import mg.aina.commerce.produit.entity.TypeTransactionStock;
import mg.aina.commerce.produit.repository.TypeTransactionStockRepository;

import java.util.List;

@Service
public class TypeTransactionStockService {
    private final TypeTransactionStockRepository typeTransactionStockRepository;

    public TypeTransactionStockService(TypeTransactionStockRepository typeTransactionStockRepository) {
        this.typeTransactionStockRepository = typeTransactionStockRepository;
    }

    public List<TypeTransactionStockDTO> findAll() {
        return typeTransactionStockRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public TypeTransactionStockDTO findById(Integer id) {
        return typeTransactionStockRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public TypeTransactionStockDTO save(TypeTransactionStockDTO dto) {
        TypeTransactionStock typeTransactionStock = new TypeTransactionStock();
        typeTransactionStock.setNom(dto.getNom());
        return toDTO(typeTransactionStockRepository.save(typeTransactionStock));
    }

    public TypeTransactionStockDTO update(Integer id, TypeTransactionStockDTO dto) {
        TypeTransactionStock existing = typeTransactionStockRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        return toDTO(typeTransactionStockRepository.save(existing));
    }

    public void delete(Integer id) {
        typeTransactionStockRepository.deleteById(id);
    }

    private TypeTransactionStockDTO toDTO(TypeTransactionStock typeTransactionStock) {
        return new TypeTransactionStockDTO(
                typeTransactionStock.getId(),
                typeTransactionStock.getNom()
        );
    }
}
