package mg.aina.commerce.caisse.repository;

import mg.aina.commerce.caisse.entity.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CaisseRepository extends JpaRepository<Caisse, Integer> {
}