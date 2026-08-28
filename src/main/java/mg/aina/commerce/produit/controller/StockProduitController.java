package mg.aina.commerce.produit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.produit.dto.StockProduitDTO;
import mg.aina.commerce.produit.service.StockProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/stock-produits")
public class StockProduitController {
    private final StockProduitService stockProduitService;

    public StockProduitController(StockProduitService stockProduitService) {
        this.stockProduitService = stockProduitService;
    }

    @GetMapping
    public List<StockProduitDTO> findAll() {
        return stockProduitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockProduitDTO> findById(@PathVariable Integer id) {
        StockProduitDTO dto = stockProduitService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StockProduitDTO create(@RequestBody StockProduitDTO dto) {
        return stockProduitService.save(dto);
    }

    @PutMapping("/{id}/{typeTransaction}")
    public ResponseEntity<StockProduitDTO> update(@PathVariable Integer id,@PathVariable Integer typeTransaction, @RequestBody StockProduitDTO dto) {
        StockProduitDTO updated = stockProduitService.update(id, dto,typeTransaction);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        stockProduitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}