package mg.aina.commerce.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.utilisateur.entity.Utilisateur;

import java.util.Optional;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
}