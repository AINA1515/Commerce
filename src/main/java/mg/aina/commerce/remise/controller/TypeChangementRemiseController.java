package mg.aina.commerce.remise.controller;

import mg.aina.commerce.remise.entity.TypeChangementRemise;
import mg.aina.commerce.remise.service.TypeChangementRemiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-changement-remises")
public class TypeChangementRemiseController {
    private final TypeChangementRemiseService service;

    public TypeChangementRemiseController(TypeChangementRemiseService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeChangementRemise> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeChangementRemise> findById(@PathVariable("id") Integer id) {
        TypeChangementRemise entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeChangementRemise create(@RequestBody TypeChangementRemise entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeChangementRemise> update(@PathVariable("id") Integer id, @RequestBody TypeChangementRemise entity) {
        TypeChangementRemise updated = service.update(id, entity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
