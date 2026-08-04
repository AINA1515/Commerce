package mg.aina.commerce.depense.repository;

import mg.aina.commerce.depense.entity.TypeDepense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDepenseRepository extends JpaRepository<TypeDepense, Integer> {
}
