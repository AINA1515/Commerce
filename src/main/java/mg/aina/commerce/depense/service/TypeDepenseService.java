package mg.aina.commerce.depense.service;

import mg.aina.commerce.depense.entity.TypeDepense;
import mg.aina.commerce.depense.repository.TypeDepenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeDepenseService {
    private final TypeDepenseRepository repository;

    public TypeDepenseService(TypeDepenseRepository repository) {
        this.repository = repository;
    }

    public List<TypeDepense> findAll() { return repository.findAll(); }
    public TypeDepense findById(Integer id) { return repository.findById(id).orElse(null); }
    public TypeDepense save(TypeDepense entity) { return repository.save(entity); }
    public TypeDepense update(Integer id, TypeDepense entity) {
        TypeDepense existing = repository.findById(id).orElse(null);
        if (existing == null) { return null; }
        existing.setNom(entity.getNom());
        return repository.save(existing);
    }
    public void delete(Integer id) { repository.deleteById(id); }
}
