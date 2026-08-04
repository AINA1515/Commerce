package mg.aina.commerce.commande.service;

import mg.aina.commerce.commande.entity.StatusLigneCommande;
import mg.aina.commerce.commande.repository.StatusLigneCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusLigneCommandeService {
    private final StatusLigneCommandeRepository repository;

    public StatusLigneCommandeService(StatusLigneCommandeRepository repository) {
        this.repository = repository;
    }

    public List<StatusLigneCommande> findAll() {
        return repository.findAll();
    }

    public StatusLigneCommande findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public StatusLigneCommande save(StatusLigneCommande entity) {
        return repository.save(entity);
    }

    public StatusLigneCommande update(Integer id, StatusLigneCommande entity) {
        StatusLigneCommande existing = repository.findById(id).orElse(null);
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