package mg.aina.commerce.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.produit.entity.TypeTransationStock;

@Repository
public interface TypeTransationStockRepository extends JpaRepository<TypeTransationStock, Integer> {
}