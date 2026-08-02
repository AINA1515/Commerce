package mg.aina.commerce.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.fournisseur.entity.TransactionFournisseurLigne;

import java.util.List;

@Repository
public interface TransactionFournisseurLigneRepository extends JpaRepository<TransactionFournisseurLigne, Integer> {
    List<TransactionFournisseurLigne> findByFournisseurId(Integer fournisseurId);
}