package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.StatusLigneCommande;
import mg.aina.commerce.commande.service.StatusLigneCommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-ligne-commandes")
public class StatusLigneCommandeController {
    private final StatusLigneCommandeService service;

    public StatusLigneCommandeController(StatusLigneCommandeService service) {
        this.service = service;
    }

    @GetMapping
    public List<StatusLigneCommande> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusLigneCommande> findById(@PathVariable("id") Integer id) {
        StatusLigneCommande entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StatusLigneCommande create(@RequestBody StatusLigneCommande entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusLigneCommande> update(@PathVariable("id") Integer id, @RequestBody StatusLigneCommande entity) {
        StatusLigneCommande updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}