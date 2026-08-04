package mg.aina.commerce.produit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.produit.dto.TypeTransationStockDTO;
import mg.aina.commerce.produit.service.TypeTransationStockService;

import java.util.List;

@RestController
@RequestMapping("/api/type-transation-stocks")
public class TypeTransationStockController {
    private final TypeTransationStockService typeTransationStockService;

    public TypeTransationStockController(TypeTransationStockService typeTransationStockService) {
        this.typeTransationStockService = typeTransationStockService;
    }

    @GetMapping
    public List<TypeTransationStockDTO> findAll() {
        return typeTransationStockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTransationStockDTO> findById(@PathVariable Integer id) {
        TypeTransationStockDTO dto = typeTransationStockService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeTransationStockDTO create(@RequestBody TypeTransationStockDTO dto) {
        return typeTransationStockService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTransationStockDTO> update(@PathVariable Integer id, @RequestBody TypeTransationStockDTO dto) {
        TypeTransationStockDTO updated = typeTransationStockService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        typeTransationStockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}