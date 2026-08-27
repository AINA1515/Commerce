package mg.aina.commerce.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.fournisseur.entity.TransactionFournisseurLigne;

import java.util.List;


public interface TransactionFournisseurLigneRepository extends JpaRepository<TransactionFournisseurLigne, Integer> {
    List<TransactionFournisseurLigne> findByFournisseurId(Integer fournisseurId);
}