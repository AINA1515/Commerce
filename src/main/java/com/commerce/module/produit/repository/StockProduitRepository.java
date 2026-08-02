package com.commerce.module.produit.repository;

import com.commerce.module.produit.entity.StockProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockProduitRepository extends JpaRepository<StockProduit, Integer> {
    Optional<StockProduit> findByProduitId(Integer produitId);
}