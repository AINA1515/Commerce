package mg.aina.commerce.depense.controller;

import mg.aina.commerce.depense.dto.HistoriqueDepenseDTO;
import mg.aina.commerce.depense.service.HistoriqueDepenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique-depenses")
public class HistoriqueDepenseController {
    private final HistoriqueDepenseService service;

    public HistoriqueDepenseController(HistoriqueDepenseService service) { this.service = service; }

    @GetMapping
    public List<HistoriqueDepenseDTO> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueDepenseDTO> findById(@PathVariable Integer id) {
        HistoriqueDepenseDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public HistoriqueDepenseDTO create(@RequestBody HistoriqueDepenseDTO dto) { return service.save(dto); }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueDepenseDTO> update(@PathVariable Integer id, @RequestBody HistoriqueDepenseDTO dto) {
        HistoriqueDepenseDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
