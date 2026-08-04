package mg.aina.commerce.depense.controller;

import mg.aina.commerce.depense.entity.TypeDepense;
import mg.aina.commerce.depense.service.TypeDepenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-depenses")
public class TypeDepenseController {
    private final TypeDepenseService service;

    public TypeDepenseController(TypeDepenseService service) { this.service = service; }

    @GetMapping
    public List<TypeDepense> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDepense> findById(@PathVariable Integer id) {
        TypeDepense entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeDepense create(@RequestBody TypeDepense entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDepense> update(@PathVariable Integer id, @RequestBody TypeDepense entity) {
        TypeDepense updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
