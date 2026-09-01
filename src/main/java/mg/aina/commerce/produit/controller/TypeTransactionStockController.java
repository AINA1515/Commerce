package mg.aina.commerce.produit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.produit.dto.TypeTransactionStockDTO;
import mg.aina.commerce.produit.service.TypeTransactionStockService;

import java.util.List;

@RestController
@RequestMapping("/api/type-transation-stocks")
public class TypeTransactionStockController {
    private final TypeTransactionStockService typeTransactionStockService;

    public TypeTransactionStockController(TypeTransactionStockService typeTransactionStockService) {
        this.typeTransactionStockService = typeTransactionStockService;
    }

    @GetMapping
    public List<TypeTransactionStockDTO> findAll() {
        return typeTransactionStockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTransactionStockDTO> findById(@PathVariable("id") Integer id) {
        TypeTransactionStockDTO dto = typeTransactionStockService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TypeTransactionStockDTO create(@RequestBody TypeTransactionStockDTO dto) {
        return typeTransactionStockService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTransactionStockDTO> update(@PathVariable("id") Integer id, @RequestBody TypeTransactionStockDTO dto) {
        TypeTransactionStockDTO updated = typeTransactionStockService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        typeTransactionStockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}