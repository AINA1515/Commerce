package mg.aina.commerce.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.utilisateur.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
}