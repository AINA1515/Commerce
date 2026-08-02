package com.commerce.module.utilisateur.service;

import com.commerce.module.utilisateur.dto.UtilisateurDTO;
import com.commerce.module.utilisateur.entity.Role;
import com.commerce.module.utilisateur.entity.Utilisateur;
import com.commerce.module.utilisateur.repository.RoleRepository;
import com.commerce.module.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    public List<UtilisateurDTO> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UtilisateurDTO findById(Integer id) {
        return utilisateurRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public UtilisateurDTO save(UtilisateurDTO dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotDePasse(dto.getMotDePasse());
        Role role = roleRepository.findById(dto.getIdRole()).orElse(null);
        utilisateur.setRole(role);
        return toDTO(utilisateurRepository.save(utilisateur));
    }

    public UtilisateurDTO update(Integer id, UtilisateurDTO dto) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if (utilisateur == null) {
            return null;
        }
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        if (dto.getMotDePasse() != null && !dto.getMotDePasse().isEmpty()) {
            utilisateur.setMotDePasse(dto.getMotDePasse());
        }
        Role role = roleRepository.findById(dto.getIdRole()).orElse(null);
        utilisateur.setRole(role);
        return toDTO(utilisateurRepository.save(utilisateur));
    }

    public void delete(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    private UtilisateurDTO toDTO(Utilisateur u) {
        return new UtilisateurDTO(
                u.getId(),
                u.getNom(),
                u.getPrenom(),
                u.getEmail(),
                u.getRole() != null ? u.getRole().getId() : null,
                u.getRole() != null ? u.getRole().getNom() : null,
                u.getDateCreation()
        );
    }
}