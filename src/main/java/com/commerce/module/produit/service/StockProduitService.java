package com.commerce.module.produit.service;

import com.commerce.module.produit.dto.StockProduitDTO;
import com.commerce.module.produit.entity.Produit;
import com.commerce.module.produit.entity.StockProduit;
import com.commerce.module.produit.repository.ProduitRepository;
import com.commerce.module.produit.repository.StockProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockProduitService {
    private final StockProduitRepository stockProduitRepository;
    private final ProduitRepository produitRepository;

    public StockProduitService(StockProduitRepository stockProduitRepository, ProduitRepository produitRepository) {
        this.stockProduitRepository = stockProduitRepository;
        this.produitRepository = produitRepository;
    }

    public List<StockProduitDTO> findAll() {
        return stockProduitRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public StockProduitDTO findById(Integer id) {
        return stockProduitRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public StockProduitDTO save(StockProduitDTO dto) {
        StockProduit stockProduit = new StockProduit();
        stockProduit.setPrixAchat(dto.getPrixAchat());
        stockProduit.setPrixVente(dto.getPrixVente());
        stockProduit.setQuantiteStock(dto.getQuantiteStock());
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        stockProduit.setProduit(produit);
        return toDTO(stockProduitRepository.save(stockProduit));
    }

    public StockProduitDTO update(Integer id, StockProduitDTO dto) {
        StockProduit stockProduit = stockProduitRepository.findById(id).orElse(null);
        if (stockProduit == null) {
            return null;
        }
        stockProduit.setPrixAchat(dto.getPrixAchat());
        stockProduit.setPrixVente(dto.getPrixVente());
        stockProduit.setQuantiteStock(dto.getQuantiteStock());
        Produit produit = produitRepository.findById(dto.getIdProduit()).orElse(null);
        stockProduit.setProduit(produit);
        return toDTO(stockProduitRepository.save(stockProduit));
    }

    public void delete(Integer id) {
        stockProduitRepository.deleteById(id);
    }

    private StockProduitDTO toDTO(StockProduit stockProduit) {
        return new StockProduitDTO(
                stockProduit.getId(),
                stockProduit.getProduit() != null ? stockProduit.getProduit().getId() : null,
                stockProduit.getProduit() != null ? stockProduit.getProduit().getNom() : null,
                stockProduit.getPrixAchat(),
                stockProduit.getPrixVente(),
                stockProduit.getQuantiteStock(),
                stockProduit.getDateModification()
        );
    }
}