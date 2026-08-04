package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.TypePayement;
import mg.aina.commerce.commande.service.TypePayementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-payements")
public class TypePayementController {
    private final TypePayementService service;

    public TypePayementController(TypePayementService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypePayement> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypePayement> findById(@PathVariable Integer id) {
        TypePayement entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypePayement create(@RequestBody TypePayement entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypePayement> update(@PathVariable Integer id, @RequestBody TypePayement entity) {
        TypePayement updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}