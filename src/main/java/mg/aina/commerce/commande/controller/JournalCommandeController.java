package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.dto.JournalCommandeDTO;
import mg.aina.commerce.commande.service.JournalCommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal-commandes")
public class JournalCommandeController {
    private final JournalCommandeService service;

    public JournalCommandeController(JournalCommandeService service) {
        this.service = service;
    }

    @GetMapping
    public List<JournalCommandeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalCommandeDTO> findById(@PathVariable Integer id) {
        JournalCommandeDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public JournalCommandeDTO create(@RequestBody JournalCommandeDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalCommandeDTO> update(@PathVariable Integer id, @RequestBody JournalCommandeDTO dto) {
        JournalCommandeDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}