package com.commerce.module.produit.repository;

import com.commerce.module.produit.entity.TypeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProduitRepository extends JpaRepository<TypeProduit, Integer> {
}