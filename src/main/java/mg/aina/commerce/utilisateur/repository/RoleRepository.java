package mg.aina.commerce.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.utilisateur.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}