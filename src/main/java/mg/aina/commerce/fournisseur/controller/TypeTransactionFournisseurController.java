package mg.aina.commerce.fournisseur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.fournisseur.dto.TypeTransactionFournisseurDTO;
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
    public List<TypeTransactionFournisseurDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTransactionFournisseurDTO> findById(@PathVariable Integer id) {
        TypeTransactionFournisseurDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeTransactionFournisseurDTO create(@RequestBody TypeTransactionFournisseurDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTransactionFournisseurDTO> update(@PathVariable Integer id, @RequestBody TypeTransactionFournisseurDTO dto) {
        TypeTransactionFournisseurDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}