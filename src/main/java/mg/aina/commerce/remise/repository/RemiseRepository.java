package mg.aina.commerce.remise.repository;

import mg.aina.commerce.remise.entity.Remise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemiseRepository extends JpaRepository<Remise, Integer> {
}