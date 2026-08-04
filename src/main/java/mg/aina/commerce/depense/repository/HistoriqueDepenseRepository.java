package mg.aina.commerce.depense.repository;

import mg.aina.commerce.depense.entity.HistoriqueDepense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueDepenseRepository extends JpaRepository<HistoriqueDepense, Integer> {
}
