package mg.aina.commerce.produit.controller;

import mg.aina.commerce.produit.dto.StockProduitDTO;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.produit.service.StockProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Stocks" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/produits/stocks")
public class StockProduitPageController {

    private final StockProduitService stockProduitService;
    private final ProduitService produitService;

    public StockProduitPageController(StockProduitService stockProduitService, ProduitService produitService) {
        this.stockProduitService = stockProduitService;
        this.produitService = produitService;
    }

    @GetMapping
    public String stocks(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("stocks", stockProduitService.findAll());
        model.addAttribute("produits", produitService.findAll());
        StockProduitDTO edit = (editId != null) ? stockProduitService.findById(editId) : null;
        model.addAttribute("editStock", edit);
        return "produit/stocks";
    }

    @PostMapping("/save")
    public String saveStock(@ModelAttribute StockProduitDTO dto) {
        if (dto.getId() != null) {
            stockProduitService.update(dto.getId(), dto, 3);
        } else {
            stockProduitService.save(dto);
        }
        return "redirect:/produits/stocks";
    }

    @PostMapping("/delete/{id}")
    public String deleteStock(@PathVariable Integer id) {
        stockProduitService.delete(id);
        return "redirect:/produits/stocks";
    }
}