package com.commerce.module.produit.controller;

import com.commerce.module.produit.entity.TypeProduit;
import com.commerce.module.produit.service.TypeProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-produits")
public class TypeProduitController {
    private final TypeProduitService typeProduitService;

    public TypeProduitController(TypeProduitService typeProduitService) {
        this.typeProduitService = typeProduitService;
    }

    @GetMapping
    public List<TypeProduit> findAll() {
        return typeProduitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeProduit> findById(@PathVariable Integer id) {
        TypeProduit typeProduit = typeProduitService.findById(id);
        return typeProduit != null ? ResponseEntity.ok(typeProduit) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeProduit create(@RequestBody TypeProduit typeProduit) {
        return typeProduitService.save(typeProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeProduit> update(@PathVariable Integer id, @RequestBody TypeProduit typeProduit) {
        TypeProduit updated = typeProduitService.update(id, typeProduit);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        typeProduitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}