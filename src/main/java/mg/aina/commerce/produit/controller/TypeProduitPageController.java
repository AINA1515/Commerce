package mg.aina.commerce.produit.controller;

import mg.aina.commerce.produit.dto.TypeProduitDTO;
import mg.aina.commerce.produit.service.TypeProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de produit" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/produits/types")
public class TypeProduitPageController {

    private final TypeProduitService typeProduitService;

    public TypeProduitPageController(TypeProduitService typeProduitService) {
        this.typeProduitService = typeProduitService;
    }

    @GetMapping
    public String types(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesProduit", typeProduitService.findAll());
        TypeProduitDTO edit = (editId != null) ? typeProduitService.findById(editId) : null;
        model.addAttribute("editTypeProduit", edit);
        return "produit/types-produit";
    }

    @PostMapping("/save")
    public String saveType(@ModelAttribute TypeProduitDTO dto) {
        if (dto.getId() != null) {
            typeProduitService.update(dto.getId(), dto);
        } else {
            typeProduitService.save(dto);
        }
        return "redirect:/produits/types";
    }

    @PostMapping("/delete/{id}")
    public String deleteType(@PathVariable Integer id) {
        typeProduitService.delete(id);
        return "redirect:/produits/types";
    }
}