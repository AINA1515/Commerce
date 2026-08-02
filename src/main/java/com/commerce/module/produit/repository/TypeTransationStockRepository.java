package com.commerce.module.produit.repository;

import com.commerce.module.produit.entity.TypeTransationStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransationStockRepository extends JpaRepository<TypeTransationStock, Integer> {
}