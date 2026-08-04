package mg.aina.commerce.caisse.service;

import mg.aina.commerce.caisse.entity.Caisse;
import mg.aina.commerce.caisse.repository.CaisseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaisseService {
    private final CaisseRepository caisseRepository;

    public CaisseService(CaisseRepository caisseRepository) {
        this.caisseRepository = caisseRepository;
    }

    public List<Caisse> findAll() {
        return caisseRepository.findAll();
    }

    public Caisse findById(Integer id) {
        return caisseRepository.findById(id).orElse(null);
    }

    public Caisse save(Caisse caisse) {
        return caisseRepository.save(caisse);
    }

    public Caisse update(Integer id, Caisse caisse) {
        Caisse existing = caisseRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setSolde(caisse.getSolde());
        return caisseRepository.save(existing);
    }

    public void delete(Integer id) {
        caisseRepository.deleteById(id);
    }
}