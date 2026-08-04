package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.TypeTransactionCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransactionCommandeRepository extends JpaRepository<TypeTransactionCommande, Integer> {
}