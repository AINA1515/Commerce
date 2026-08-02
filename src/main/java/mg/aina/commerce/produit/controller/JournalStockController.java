package mg.aina.commerce.produit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.produit.dto.JournalStockDTO;
import mg.aina.commerce.produit.service.JournalStockService;

import java.util.List;

@RestController
@RequestMapping("/api/journal-stocks")
public class JournalStockController {
    private final JournalStockService journalStockService;

    public JournalStockController(JournalStockService journalStockService) {
        this.journalStockService = journalStockService;
    }

    @GetMapping
    public List<JournalStockDTO> findAll() {
        return journalStockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalStockDTO> findById(@PathVariable Integer id) {
        JournalStockDTO dto = journalStockService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/produit/{produitId}")
    public List<JournalStockDTO> findByProduitId(@PathVariable Integer produitId) {
        return journalStockService.findByProduitId(produitId);
    }

    @PostMapping
    public JournalStockDTO create(@RequestBody JournalStockDTO dto) {
        return journalStockService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalStockDTO> update(@PathVariable Integer id, @RequestBody JournalStockDTO dto) {
        JournalStockDTO updated = journalStockService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        journalStockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}