package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.produit.entity.JournalStock;

import java.util.List;


public interface JournalStockRepository extends JpaRepository<JournalStock, Integer> {
    List<JournalStock> findByProduitId(Integer produitId);
}