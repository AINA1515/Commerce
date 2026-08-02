package mg.aina.commerce.produit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.produit.dto.ProduitDTO;
import mg.aina.commerce.produit.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<ProduitDTO> findAll() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> findById(@PathVariable Integer id) {
        ProduitDTO dto = produitService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProduitDTO create(@RequestBody ProduitDTO dto) {
        return produitService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitDTO> update(@PathVariable Integer id, @RequestBody ProduitDTO dto) {
        ProduitDTO updated = produitService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}