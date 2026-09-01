package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.dto.PayementDTO;
import mg.aina.commerce.commande.service.PayementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payements")
public class PayementController {
    private final PayementService service;

    public PayementController(PayementService service) {
        this.service = service;
    }

    @GetMapping
    public List<PayementDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayementDTO> findById(@PathVariable("id") Integer id) {
        PayementDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/ligne-commande/{id}")
    public List<PayementDTO> findByLigneCommandeId(@PathVariable("id") Integer ligneCommandeId) {
        return service.findByLigneCommandeId(ligneCommandeId);
    }

    @PostMapping
    public PayementDTO create(@RequestBody PayementDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayementDTO> update(@PathVariable("id") Integer id, @RequestBody PayementDTO dto) {
        PayementDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}