package mg.aina.commerce.commande.service;

import mg.aina.commerce.commande.entity.StatusCommande;
import mg.aina.commerce.commande.repository.StatusCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusCommandeService {
    private final StatusCommandeRepository repository;

    public StatusCommandeService(StatusCommandeRepository repository) {
        this.repository = repository;
    }

    public List<StatusCommande> findAll() {
        return repository.findAll();
    }

    public StatusCommande findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public StatusCommande save(StatusCommande entity) {
        return repository.save(entity);
    }

    public StatusCommande update(Integer id, StatusCommande entity) {
        StatusCommande existing = repository.findById(id).orElse(null);
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