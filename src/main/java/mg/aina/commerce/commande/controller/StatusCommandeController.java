package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.StatusCommande;
import mg.aina.commerce.commande.service.StatusCommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-commandes")
public class StatusCommandeController {
    private final StatusCommandeService service;

    public StatusCommandeController(StatusCommandeService service) {
        this.service = service;
    }

    @GetMapping
    public List<StatusCommande> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusCommande> findById(@PathVariable("id") Integer id) {
        StatusCommande entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StatusCommande create(@RequestBody StatusCommande entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusCommande> update(@PathVariable("id") Integer id, @RequestBody StatusCommande entity) {
        StatusCommande updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}