package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.produit.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}