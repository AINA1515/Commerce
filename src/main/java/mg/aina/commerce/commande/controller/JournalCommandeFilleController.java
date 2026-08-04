package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.dto.JournalCommandeFilleDTO;
import mg.aina.commerce.commande.service.JournalCommandeFilleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal-commande-filles")
public class JournalCommandeFilleController {
    private final JournalCommandeFilleService service;

    public JournalCommandeFilleController(JournalCommandeFilleService service) {
        this.service = service;
    }

    @GetMapping
    public List<JournalCommandeFilleDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalCommandeFilleDTO> findById(@PathVariable Integer id) {
        JournalCommandeFilleDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public JournalCommandeFilleDTO create(@RequestBody JournalCommandeFilleDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalCommandeFilleDTO> update(@PathVariable Integer id, @RequestBody JournalCommandeFilleDTO dto) {
        JournalCommandeFilleDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}