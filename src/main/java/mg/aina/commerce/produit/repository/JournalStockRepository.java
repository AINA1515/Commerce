package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.produit.entity.JournalStock;

import java.util.List;

@Repository
public interface JournalStockRepository extends JpaRepository<JournalStock, Integer> {
    List<JournalStock> findByProduitId(Integer produitId);
}