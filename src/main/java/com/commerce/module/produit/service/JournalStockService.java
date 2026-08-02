package com.commerce.module.produit.service;

import com.commerce.module.produit.dto.JournalStockDTO;
import com.commerce.module.produit.entity.JournalStock;
import com.commerce.module.produit.entity.Produit;
import com.commerce.module.produit.entity.TypeTransationStock;
import com.commerce.module.produit.repository.JournalStockRepository;
import com.commerce.module.produit.repository.ProduitRepository;
import com.commerce.module.produit.repository.TypeTransationStockRepository;
import com.commerce.module.utilisateur.entity.Utilisateur;
import com.commerce.module.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalStockService {
    private final JournalStockRepository journalStockRepository;
    private final ProduitRepository produitRepository;
    private final TypeTransationStockRepository typeTransationStockRepository;
    private final UtilisateurRepository utilisateurRepository;

    public JournalStockService(JournalStockRepository journalStockRepository,
                               ProduitRepository produitRepository,
                               TypeTransationStockRepository typeTransationStockRepository,
                               UtilisateurRepository utilisateurRepository) {
        this.journalStockRepository = journalStockRepository;
        this.produitRepository = produitRepository;
        this.typeTransationStockRepository = typeTransationStockRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<JournalStockDTO> findAll() {
        return journalStockRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public JournalStockDTO findById(Integer id) {
        return journalStockRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<JournalStockDTO> findByProduitId(Integer produitId) {
        return journalStockRepository.findByProduitId(produitId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public JournalStockDTO save(JournalStockDTO dto) {
        JournalStock journalStock = new JournalStock();
        journalStock.setQuantite(dto.getQuantite());
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        TypeTransationStock typeTransationStock = typeTransationStockRepository.findById(dto.getIdTypeTransationStock()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        journalStock.setProduit(produit);
        journalStock.setTypeTransationStock(typeTransationStock);
        journalStock.setUtilisateur(utilisateur);
        return toDTO(journalStockRepository.save(journalStock));
    }

    public JournalStockDTO update(Integer id, JournalStockDTO dto) {
        JournalStock journalStock = journalStockRepository.findById(id).orElse(null);
        if (journalStock == null) {
            return null;
        }
        journalStock.setQuantite(dto.getQuantite());
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        TypeTransationStock typeTransationStock = typeTransationStockRepository.findById(dto.getIdTypeTransationStock()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElse(null);
        journalStock.setProduit(produit);
        journalStock.setTypeTransationStock(typeTransationStock);
        journalStock.setUtilisateur(utilisateur);
        return toDTO(journalStockRepository.save(journalStock));
    }

    public void delete(Integer id) {
        journalStockRepository.deleteById(id);
    }

    private JournalStockDTO toDTO(JournalStock journalStock) {
        return new JournalStockDTO(
                journalStock.getId(),
                journalStock.getProduit() != null ? journalStock.getProduit().getId() : null,
                journalStock.getProduit() != null ? journalStock.getProduit().getNom() : null,
                journalStock.getTypeTransationStock() != null ? journalStock.getTypeTransationStock().getId() : null,
                journalStock.getTypeTransationStock() != null ? journalStock.getTypeTransationStock().getNom() : null,
                journalStock.getQuantite(),
                journalStock.getUtilisateur() != null ? journalStock.getUtilisateur().getId() : null,
                journalStock.getUtilisateur() != null ? journalStock.getUtilisateur().getNom() + " " + journalStock.getUtilisateur().getPrenom() : null,
                journalStock.getDateModification()
        );
    }
}