package mg.aina.commerce.caisse.controller;

import mg.aina.commerce.caisse.entity.Caisse;
import mg.aina.commerce.caisse.service.CaisseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caisse")
public class CaisseController {
    private final CaisseService service;

    public CaisseController(CaisseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Caisse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caisse> findById(@PathVariable("id") Integer id) {
        Caisse entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Caisse create(@RequestBody Caisse entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caisse> update(@PathVariable("id") Integer id, @RequestBody Caisse entity) {
        Caisse updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}