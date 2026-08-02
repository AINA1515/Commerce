package com.commerce.module.utilisateur.service;

import com.commerce.module.utilisateur.entity.Role;
import com.commerce.module.utilisateur.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Integer id, Role role) {
        Role existing = roleRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(role.getNom());
        return roleRepository.save(existing);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}