package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.dto.LigneCommandeDTO;
import mg.aina.commerce.commande.service.LigneCommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ligne-commandes")
public class LigneCommandeController {
    private final LigneCommandeService service;

    public LigneCommandeController(LigneCommandeService service) {
        this.service = service;
    }

    @GetMapping
    public List<LigneCommandeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommandeDTO> findById(@PathVariable Integer id) {
        LigneCommandeDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/commande/{commandeId}")
    public List<LigneCommandeDTO> findByCommandeId(@PathVariable Integer commandeId) {
        return service.findByCommandeId(commandeId);
    }

    @PostMapping
    public LigneCommandeDTO create(@RequestBody LigneCommandeDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneCommandeDTO> update(@PathVariable Integer id, @RequestBody LigneCommandeDTO dto) {
        LigneCommandeDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}