package com.commerce.module.produit.controller;

import com.commerce.module.produit.entity.TypeTransationStock;
import com.commerce.module.produit.service.TypeTransationStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-transation-stocks")
public class TypeTransationStockController {
    private final TypeTransationStockService typeTransationStockService;

    public TypeTransationStockController(TypeTransationStockService typeTransationStockService) {
        this.typeTransationStockService = typeTransationStockService;
    }

    @GetMapping
    public List<TypeTransationStock> findAll() {
        return typeTransationStockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTransationStock> findById(@PathVariable Integer id) {
        TypeTransationStock typeTransationStock = typeTransationStockService.findById(id);
        return typeTransationStock != null ? ResponseEntity.ok(typeTransationStock) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeTransationStock create(@RequestBody TypeTransationStock typeTransationStock) {
        return typeTransationStockService.save(typeTransationStock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTransationStock> update(@PathVariable Integer id, @RequestBody TypeTransationStock typeTransationStock) {
        TypeTransationStock updated = typeTransationStockService.update(id, typeTransationStock);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        typeTransationStockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}