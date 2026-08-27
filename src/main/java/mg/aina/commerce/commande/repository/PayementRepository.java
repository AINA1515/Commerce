package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.Payement;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface PayementRepository extends JpaRepository<Payement, Integer> {
    List<Payement> findByLigneCommandeId(Integer ligneCommandeId);
}