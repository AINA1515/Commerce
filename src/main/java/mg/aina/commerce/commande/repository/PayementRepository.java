package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayementRepository extends JpaRepository<Payement, Integer> {
    List<Payement> findByLigneCommandeId(Integer ligneCommandeId);
}