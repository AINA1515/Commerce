package com.commerce.module.fournisseur.repository;

import com.commerce.module.fournisseur.entity.TransactionFournisseurLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionFournisseurLigneRepository extends JpaRepository<TransactionFournisseurLigne, Integer> {
    List<TransactionFournisseurLigne> findByFournisseurId(Integer fournisseurId);
}