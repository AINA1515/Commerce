package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.produit.entity.TypeProduit;

@Repository
public interface TypeProduitRepository extends JpaRepository<TypeProduit, Integer> {
}