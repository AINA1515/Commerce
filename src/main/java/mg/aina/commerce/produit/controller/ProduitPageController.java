package mg.aina.commerce.produit.controller;

import mg.aina.commerce.produit.dto.ProduitDTO;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.produit.service.TypeProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Produits" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/produits")
public class ProduitPageController {

    private final ProduitService produitService;
    private final TypeProduitService typeProduitService;

    public ProduitPageController(ProduitService produitService, TypeProduitService typeProduitService) {
        this.produitService = produitService;
        this.typeProduitService = typeProduitService;
    }

    @GetMapping
    public String produits(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("typesProduit", typeProduitService.findAll());
        ProduitDTO edit = (editId != null) ? produitService.findById(editId) : null;
        model.addAttribute("editProduit", edit);
        return "produit/produits";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute ProduitDTO dto) {
        if (dto.getId() != null) {
            produitService.update(dto.getId(), dto);
        } else {
            produitService.save(dto);
        }
        return "redirect:/produits";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduit(@PathVariable Integer id) {
        produitService.delete(id);
        return "redirect:/produits";
    }
}