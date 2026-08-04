package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.JournalCommandeFille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalCommandeFilleRepository extends JpaRepository<JournalCommandeFille, Integer> {
}