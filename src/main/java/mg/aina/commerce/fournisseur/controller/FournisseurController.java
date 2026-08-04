package mg.aina.commerce.fournisseur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.fournisseur.dto.FournisseurDTO;
import mg.aina.commerce.fournisseur.service.FournisseurService;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public List<FournisseurDTO> findAll() {
        return fournisseurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> findById(@PathVariable Integer id) {
        FournisseurDTO dto = fournisseurService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public FournisseurDTO create(@RequestBody FournisseurDTO dto) {
        return fournisseurService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FournisseurDTO> update(@PathVariable Integer id, @RequestBody FournisseurDTO dto) {
        FournisseurDTO updated = fournisseurService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        fournisseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}