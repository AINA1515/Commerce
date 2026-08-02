package com.commerce.module.produit.service;

import com.commerce.module.produit.entity.TypeTransationStock;
import com.commerce.module.produit.repository.TypeTransationStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTransationStockService {
    private final TypeTransationStockRepository typeTransationStockRepository;

    public TypeTransationStockService(TypeTransationStockRepository typeTransationStockRepository) {
        this.typeTransationStockRepository = typeTransationStockRepository;
    }

    public List<TypeTransationStock> findAll() {
        return typeTransationStockRepository.findAll();
    }

    public TypeTransationStock findById(Integer id) {
        return typeTransationStockRepository.findById(id).orElse(null);
    }

    public TypeTransationStock save(TypeTransationStock typeTransationStock) {
        return typeTransationStockRepository.save(typeTransationStock);
    }

    public TypeTransationStock update(Integer id, TypeTransationStock typeTransationStock) {
        TypeTransationStock existing = typeTransationStockRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(typeTransationStock.getNom());
        return typeTransationStockRepository.save(existing);
    }

    public void delete(Integer id) {
        typeTransationStockRepository.deleteById(id);
    }
}