package mg.aina.commerce.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.fournisseur.entity.TypeTransactionFournisseur;

@Repository
public interface TypeTransactionFournisseurRepository extends JpaRepository<TypeTransactionFournisseur, Integer> {
}