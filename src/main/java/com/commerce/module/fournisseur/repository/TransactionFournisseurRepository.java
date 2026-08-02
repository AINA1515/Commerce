package com.commerce.module.fournisseur.repository;

import com.commerce.module.fournisseur.entity.TransactionFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionFournisseurRepository extends JpaRepository<TransactionFournisseur, Integer> {
}