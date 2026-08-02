package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.produit.entity.StockProduit;

import java.util.Optional;

@Repository
public interface StockProduitRepository extends JpaRepository<StockProduit, Integer> {
    Optional<StockProduit> findByProduitId(Integer produitId);
}