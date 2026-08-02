package com.commerce.module.fournisseur.controller;

import com.commerce.module.fournisseur.dto.TransactionFournisseurDTO;
import com.commerce.module.fournisseur.service.TransactionFournisseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions-fournisseurs")
public class TransactionFournisseurController {
    private final TransactionFournisseurService service;

    public TransactionFournisseurController(TransactionFournisseurService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransactionFournisseurDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionFournisseurDTO> findById(@PathVariable Integer id) {
        TransactionFournisseurDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TransactionFournisseurDTO create(@RequestBody TransactionFournisseurDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionFournisseurDTO> update(@PathVariable Integer id, @RequestBody TransactionFournisseurDTO dto) {
        TransactionFournisseurDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}