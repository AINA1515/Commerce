package mg.aina.commerce.fournisseur.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.fournisseur.entity.TypeTransactionFournisseur;
import mg.aina.commerce.fournisseur.repository.TypeTransactionFournisseurRepository;

import java.util.List;

@Service
public class TypeTransactionFournisseurService {
    private final TypeTransactionFournisseurRepository typeTransactionFournisseurRepository;

    public TypeTransactionFournisseurService(TypeTransactionFournisseurRepository typeTransactionFournisseurRepository) {
        this.typeTransactionFournisseurRepository = typeTransactionFournisseurRepository;
    }

    public List<TypeTransactionFournisseur> findAll() {
        return typeTransactionFournisseurRepository.findAll();
    }

    public TypeTransactionFournisseur findById(Integer id) {
        return typeTransactionFournisseurRepository.findById(id).orElse(null);
    }

    public TypeTransactionFournisseur save(TypeTransactionFournisseur typeTransactionFournisseur) {
        return typeTransactionFournisseurRepository.save(typeTransactionFournisseur);
    }

    public TypeTransactionFournisseur update(Integer id, TypeTransactionFournisseur typeTransactionFournisseur) {
        TypeTransactionFournisseur existing = typeTransactionFournisseurRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(typeTransactionFournisseur.getNom());
        return typeTransactionFournisseurRepository.save(existing);
    }

    public void delete(Integer id) {
        typeTransactionFournisseurRepository.deleteById(id);
    }
}