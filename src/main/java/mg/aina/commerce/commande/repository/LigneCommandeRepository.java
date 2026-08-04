package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
    List<LigneCommande> findByCommandeId(Integer commandeId);
}