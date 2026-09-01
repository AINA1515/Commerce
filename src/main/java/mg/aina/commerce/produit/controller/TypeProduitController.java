package mg.aina.commerce.produit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.produit.dto.TypeProduitDTO;
import mg.aina.commerce.produit.service.TypeProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/type-produits")
public class TypeProduitController {
    private final TypeProduitService typeProduitService;

    public TypeProduitController(TypeProduitService typeProduitService) {
        this.typeProduitService = typeProduitService;
    }

    @GetMapping
    public List<TypeProduitDTO> findAll() {
        return typeProduitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeProduitDTO> findById(@PathVariable("id") Integer id) {
        TypeProduitDTO dto = typeProduitService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeProduitDTO create(@RequestBody TypeProduitDTO dto) {
        return typeProduitService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeProduitDTO> update(@PathVariable("id") Integer id, @RequestBody TypeProduitDTO dto) {
        TypeProduitDTO updated = typeProduitService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        typeProduitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}