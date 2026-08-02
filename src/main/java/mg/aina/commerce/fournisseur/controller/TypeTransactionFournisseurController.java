package mg.aina.commerce.fournisseur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.fournisseur.entity.TypeTransactionFournisseur;
import mg.aina.commerce.fournisseur.service.TypeTransactionFournisseurService;

import java.util.List;

@RestController
@RequestMapping("/api/type-transaction-fournisseurs")
public class TypeTransactionFournisseurController {
    private final TypeTransactionFournisseurService service;

    public TypeTransactionFournisseurController(TypeTransactionFournisseurService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeTransactionFournisseur> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTransactionFournisseur> findById(@PathVariable Integer id) {
        TypeTransactionFournisseur entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeTransactionFournisseur create(@RequestBody TypeTransactionFournisseur entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTransactionFournisseur> update(@PathVariable Integer id, @RequestBody TypeTransactionFournisseur entity) {
        TypeTransactionFournisseur updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}