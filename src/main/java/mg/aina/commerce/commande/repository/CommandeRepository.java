package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}