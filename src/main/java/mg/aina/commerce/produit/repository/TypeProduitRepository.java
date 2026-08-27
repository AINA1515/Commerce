package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.produit.entity.TypeProduit;


public interface TypeProduitRepository extends JpaRepository<TypeProduit, Integer> {
}