package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.JournalCommande;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JournalCommandeRepository extends JpaRepository<JournalCommande, Integer> {
}