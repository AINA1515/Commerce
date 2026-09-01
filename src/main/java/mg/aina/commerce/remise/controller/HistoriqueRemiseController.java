package mg.aina.commerce.remise.controller;

import mg.aina.commerce.remise.dto.HistoriqueRemiseDTO;
import mg.aina.commerce.remise.service.HistoriqueRemiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique-remises")
public class HistoriqueRemiseController {
    private final HistoriqueRemiseService service;

    public HistoriqueRemiseController(HistoriqueRemiseService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistoriqueRemiseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueRemiseDTO> findById(@PathVariable("id") Integer id) {
        HistoriqueRemiseDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public HistoriqueRemiseDTO create(@RequestBody HistoriqueRemiseDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueRemiseDTO> update(@PathVariable("id") Integer id, @RequestBody HistoriqueRemiseDTO dto) {
        HistoriqueRemiseDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
