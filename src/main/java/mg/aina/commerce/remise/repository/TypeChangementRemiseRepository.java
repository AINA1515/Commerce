package mg.aina.commerce.remise.repository;

import mg.aina.commerce.remise.entity.TypeChangementRemise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeChangementRemiseRepository extends JpaRepository<TypeChangementRemise, Integer> {
}