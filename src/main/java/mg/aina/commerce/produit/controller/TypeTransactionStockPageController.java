package mg.aina.commerce.produit.controller;

import mg.aina.commerce.produit.dto.TypeTransactionStockDTO;
import mg.aina.commerce.produit.service.TypeTransactionStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de transaction stock" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/produits/types-transaction-stock")
public class TypeTransactionStockPageController {

    private final TypeTransactionStockService typeTransactionStockService;

    public TypeTransactionStockPageController(TypeTransactionStockService typeTransactionStockService) {
        this.typeTransactionStockService = typeTransactionStockService;
    }

    @GetMapping
    public String typesTransactionStock(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesTransactionStock", typeTransactionStockService.findAll());
        TypeTransactionStockDTO edit = (editId != null) ? typeTransactionStockService.findById(editId) : null;
        model.addAttribute("editTypeTransactionStock", edit);
        return "produit/types-transaction-stock";
    }

    @PostMapping("/save")
    public String saveTypeTransactionStock(@ModelAttribute TypeTransactionStockDTO dto) {
        if (dto.getId() != null) {
            typeTransactionStockService.update(dto.getId(), dto);
        } else {
            typeTransactionStockService.save(dto);
        }
        return "redirect:/produits/types-transaction-stock";
    }

    @PostMapping("/delete/{id}")
    public String deleteTypeTransactionStock(@PathVariable Integer id) {
        typeTransactionStockService.delete(id);
        return "redirect:/produits/types-transaction-stock";
    }
}