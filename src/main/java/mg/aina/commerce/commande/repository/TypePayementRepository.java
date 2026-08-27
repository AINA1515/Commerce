package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.TypePayement;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TypePayementRepository extends JpaRepository<TypePayement, Integer> {
}