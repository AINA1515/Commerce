package mg.aina.commerce.commande.repository;

import mg.aina.commerce.commande.entity.TypePayement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePayementRepository extends JpaRepository<TypePayement, Integer> {
}