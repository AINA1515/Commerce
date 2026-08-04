package mg.aina.commerce.utilisateur.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.utilisateur.dto.RoleDTO;
import mg.aina.commerce.utilisateur.entity.Role;
import mg.aina.commerce.utilisateur.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public RoleDTO findById(Integer id) {
        return roleRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public RoleDTO save(RoleDTO dto) {
        Role role = new Role();
        role.setNom(dto.getNom());
        return toDTO(roleRepository.save(role));
    }

    public RoleDTO update(Integer id, RoleDTO dto) {
        Role existing = roleRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        return toDTO(roleRepository.save(existing));
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    private RoleDTO toDTO(Role role) {
        return new RoleDTO(
                role.getId(),
                role.getNom()
        );
    }
}
