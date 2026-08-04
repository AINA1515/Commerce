package mg.aina.commerce.commande.service;

import mg.aina.commerce.commande.entity.TypeTransactionCommande;
import mg.aina.commerce.commande.repository.TypeTransactionCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTransactionCommandeService {
    private final TypeTransactionCommandeRepository repository;

    public TypeTransactionCommandeService(TypeTransactionCommandeRepository repository) {
        this.repository = repository;
    }

    public List<TypeTransactionCommande> findAll() {
        return repository.findAll();
    }

    public TypeTransactionCommande findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public TypeTransactionCommande save(TypeTransactionCommande entity) {
        return repository.save(entity);
    }

    public TypeTransactionCommande update(Integer id, TypeTransactionCommande entity) {
        TypeTransactionCommande existing = repository.findById(id).orElse(null);
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