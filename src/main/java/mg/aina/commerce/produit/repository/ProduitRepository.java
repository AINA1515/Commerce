package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.produit.entity.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}