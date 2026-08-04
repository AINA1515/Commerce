package mg.aina.commerce.remise.repository;

import mg.aina.commerce.remise.entity.HistoriqueRemise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueRemiseRepository extends JpaRepository<HistoriqueRemise, Integer> {
}