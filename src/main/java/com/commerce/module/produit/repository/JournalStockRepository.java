package com.commerce.module.produit.repository;

import com.commerce.module.produit.entity.JournalStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalStockRepository extends JpaRepository<JournalStock, Integer> {
    List<JournalStock> findByProduitId(Integer produitId);
}