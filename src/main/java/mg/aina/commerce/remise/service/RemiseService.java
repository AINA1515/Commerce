package mg.aina.commerce.remise.service;

import mg.aina.commerce.produit.entity.Produit;
import mg.aina.commerce.produit.repository.ProduitRepository;
import mg.aina.commerce.remise.dto.RemiseDTO;
import mg.aina.commerce.remise.entity.Remise;
import mg.aina.commerce.remise.repository.RemiseRepository;
import mg.aina.commerce.utilisateur.entity.Utilisateur;
import mg.aina.commerce.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemiseService {
    private final RemiseRepository remiseRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ProduitRepository produitRepository;

    public RemiseService(RemiseRepository remiseRepository,
                         UtilisateurRepository utilisateurRepository,
                         ProduitRepository produitRepository) {
        this.remiseRepository = remiseRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.produitRepository = produitRepository;
    }

    public List<RemiseDTO> findAll() {
        return remiseRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public RemiseDTO findById(Integer id) {
        return remiseRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public RemiseDTO save(RemiseDTO dto) {
        Remise remise = new Remise();
        remise.setPourcentage(dto.getPourcentage());
        remise.setDateDebut(dto.getDateDebut());
        remise.setDateFin(dto.getDateFin());
        remise.setDisponiblite(dto.getDisponiblite());
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        remise.setUtilisateur(utilisateur);
        remise.setProduit(produit);
        return toDTO(remiseRepository.save(remise));
    }

    public RemiseDTO update(Integer id, RemiseDTO dto) {
        Remise remise = remiseRepository.findById(id).orElse(null);
        if (remise == null) {
            return null;
        }
        remise.setPourcentage(dto.getPourcentage());
        remise.setDateDebut(dto.getDateDebut());
        remise.setDateFin(dto.getDateFin());
        remise.setDisponiblite(dto.getDisponiblite());
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        remise.setUtilisateur(utilisateur);
        remise.setProduit(produit);
        return toDTO(remiseRepository.save(remise));
    }

    public void delete(Integer id) {
        remiseRepository.deleteById(id);
    }

    private RemiseDTO toDTO(Remise remise) {
        return new RemiseDTO(
                remise.getId(),
                remise.getUtilisateur() != null ? remise.getUtilisateur().getId() : null,
                remise.getUtilisateur() != null ? remise.getUtilisateur().getNom() + " " + remise.getUtilisateur().getPrenom() : null,
                remise.getProduit() != null ? remise.getProduit().getId() : null,
                remise.getProduit() != null ? remise.getProduit().getNom() : null,
                remise.getPourcentage(),
                remise.getDateDebut(),
                remise.getDateFin(),
                remise.getDisponiblite()
        );
    }
}