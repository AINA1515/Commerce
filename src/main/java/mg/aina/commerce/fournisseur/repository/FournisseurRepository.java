package mg.aina.commerce.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.fournisseur.entity.Fournisseur;


public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}