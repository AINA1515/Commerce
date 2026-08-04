package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.StatusCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusCommandeRepository extends JpaRepository<StatusCommande, Integer> {
}