package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
    List<LigneCommande> findByCommandeId(Integer commandeId);
}