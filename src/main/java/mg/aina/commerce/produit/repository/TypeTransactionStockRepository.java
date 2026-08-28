package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.aina.commerce.produit.entity.TypeTransactionStock;

import java.util.Optional;

public interface TypeTransactionStockRepository extends JpaRepository<TypeTransactionStock, Integer> {
    Optional<TypeTransactionStock> findByNom(String nom);
}