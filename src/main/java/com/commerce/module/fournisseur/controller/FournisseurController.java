package com.commerce.module.fournisseur.controller;

import com.commerce.module.fournisseur.entity.Fournisseur;
import com.commerce.module.fournisseur.service.FournisseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> findById(@PathVariable Integer id) {
        Fournisseur fournisseur = fournisseurService.findById(id);
        return fournisseur != null ? ResponseEntity.ok(fournisseur) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fournisseur create(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Integer id, @RequestBody Fournisseur fournisseur) {
        Fournisseur updated = fournisseurService.update(id, fournisseur);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        fournisseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}