package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.TypeTransactionCommande;
import mg.aina.commerce.commande.service.TypeTransactionCommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-transaction-commandes")
public class TypeTransactionCommandeController {
    private final TypeTransactionCommandeService service;

    public TypeTransactionCommandeController(TypeTransactionCommandeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeTransactionCommande> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTransactionCommande> findById(@PathVariable("id") Integer id) {
        TypeTransactionCommande entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeTransactionCommande create(@RequestBody TypeTransactionCommande entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTransactionCommande> update(@PathVariable("id") Integer id, @RequestBody TypeTransactionCommande entity) {
        TypeTransactionCommande updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}