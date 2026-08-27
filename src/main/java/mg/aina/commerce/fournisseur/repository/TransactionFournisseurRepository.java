package mg.aina.commerce.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.fournisseur.entity.TransactionFournisseur;


public interface TransactionFournisseurRepository extends JpaRepository<TransactionFournisseur, Integer> {
}