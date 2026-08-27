package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.StatusLigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StatusLigneCommandeRepository extends JpaRepository<StatusLigneCommande, Integer> {
}