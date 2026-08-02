package com.commerce.module.fournisseur.repository;

import com.commerce.module.fournisseur.entity.TypeTransactionFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransactionFournisseurRepository extends JpaRepository<TypeTransactionFournisseur, Integer> {
}