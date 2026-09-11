package mg.aina.commerce.produit.controller;

import mg.aina.commerce.produit.dto.JournalStockDTO;
import mg.aina.commerce.produit.service.JournalStockService;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.produit.service.TypeTransactionStockService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Journal des stocks" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/produits/journal-stocks")
public class JournalStockPageController {

    private final JournalStockService journalStockService;
    private final ProduitService produitService;
    private final TypeTransactionStockService typeTransactionStockService;
    private final UtilisateurService utilisateurService;

    public JournalStockPageController(JournalStockService journalStockService,
                                      ProduitService produitService,
                                      TypeTransactionStockService typeTransactionStockService,
                                      UtilisateurService utilisateurService) {
        this.journalStockService = journalStockService;
        this.produitService = produitService;
        this.typeTransactionStockService = typeTransactionStockService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String journalStocks(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("journalStocks", journalStockService.findAll());
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("typesTransactionStock", typeTransactionStockService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        JournalStockDTO edit = (editId != null) ? journalStockService.findById(editId) : null;
        model.addAttribute("editJournalStock", edit);
        return "produit/journal-stocks";
    }

    @PostMapping("/save")
    public String saveJournalStock(@ModelAttribute JournalStockDTO dto) {
        if (dto.getIdProduit() != null) {
            journalStockService.save(dto);
        }
        return "redirect:/produits/journal-stocks";
    }

    @PostMapping("/delete/{id}")
    public String deleteJournalStock(@PathVariable Integer id) {
        journalStockService.delete(id);
        return "redirect:/produits/journal-stocks";
    }
}