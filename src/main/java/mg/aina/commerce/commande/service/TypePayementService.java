package mg.aina.commerce.commande.service;

import mg.aina.commerce.commande.entity.TypePayement;
import mg.aina.commerce.commande.repository.TypePayementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePayementService {
    private final TypePayementRepository typePayementRepository;

    public TypePayementService(TypePayementRepository typePayementRepository) {
        this.typePayementRepository = typePayementRepository;
    }

    public List<TypePayement> findAll() {
        return typePayementRepository.findAll();
    }

    public TypePayement findById(Integer id) {
        return typePayementRepository.findById(id).orElse(null);
    }

    public TypePayement save(TypePayement typePayement) {
        return typePayementRepository.save(typePayement);
    }

    public TypePayement update(Integer id, TypePayement typePayement) {
        TypePayement existing = typePayementRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(typePayement.getNom());
        return typePayementRepository.save(existing);
    }

    public void delete(Integer id) {
        typePayementRepository.deleteById(id);
    }
}