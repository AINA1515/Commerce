package com.commerce.module.fournisseur.repository;

import com.commerce.module.fournisseur.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}