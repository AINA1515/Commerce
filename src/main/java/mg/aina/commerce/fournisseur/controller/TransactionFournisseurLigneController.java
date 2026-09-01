package mg.aina.commerce.fournisseur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.fournisseur.dto.TransactionFournisseurLigneDTO;
import mg.aina.commerce.fournisseur.service.TransactionFournisseurLigneService;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-fournisseur-lignes")
public class TransactionFournisseurLigneController {
    private final TransactionFournisseurLigneService service;

    public TransactionFournisseurLigneController(TransactionFournisseurLigneService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransactionFournisseurLigneDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionFournisseurLigneDTO> findById(@PathVariable("id") Integer id) {
        TransactionFournisseurLigneDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/fournisseur/{fournisseurId}")
    public List<TransactionFournisseurLigneDTO> findByFournisseurId(@PathVariable("id") Integer fournisseurId) {
        return service.findByFournisseurId(fournisseurId);
    }

    @PostMapping
    public TransactionFournisseurLigneDTO create(@RequestBody TransactionFournisseurLigneDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionFournisseurLigneDTO> update(@PathVariable("id") Integer id,
            @RequestBody TransactionFournisseurLigneDTO dto) {
        TransactionFournisseurLigneDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}