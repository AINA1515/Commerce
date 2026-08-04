package mg.aina.commerce.remise.service;

import mg.aina.commerce.remise.entity.TypeChangementRemise;
import mg.aina.commerce.remise.repository.TypeChangementRemiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeChangementRemiseService {
    private final TypeChangementRemiseRepository repository;

    public TypeChangementRemiseService(TypeChangementRemiseRepository repository) {
        this.repository = repository;
    }

    public List<TypeChangementRemise> findAll() {
        return repository.findAll();
    }

    public TypeChangementRemise findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public TypeChangementRemise save(TypeChangementRemise entity) {
        return repository.save(entity);
    }

    public TypeChangementRemise update(Integer id, TypeChangementRemise entity) {
        TypeChangementRemise existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(entity.getNom());
        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}