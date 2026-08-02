package com.commerce.module.fournisseur.service;

import com.commerce.module.fournisseur.entity.Fournisseur;
import com.commerce.module.fournisseur.repository.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findById(Integer id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public Fournisseur update(Integer id, Fournisseur fournisseur) {
        Fournisseur existing = fournisseurRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(fournisseur.getNom());
        existing.setPrenom(fournisseur.getPrenom());
        existing.setEmail(fournisseur.getEmail());
        existing.setTelephone(fournisseur.getTelephone());
        existing.setAdresse(fournisseur.getAdresse());
        return fournisseurRepository.save(existing);
    }

    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);
    }
}