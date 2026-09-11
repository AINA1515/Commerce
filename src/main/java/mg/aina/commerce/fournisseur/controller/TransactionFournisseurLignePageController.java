package mg.aina.commerce.fournisseur.controller;

import mg.aina.commerce.fournisseur.dto.TransactionFournisseurLigneDTO;
import mg.aina.commerce.fournisseur.service.FournisseurService;
import mg.aina.commerce.fournisseur.service.TransactionFournisseurLigneService;
import mg.aina.commerce.fournisseur.service.TransactionFournisseurService;
import mg.aina.commerce.produit.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Lignes de transaction fournisseur" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/fournisseurs/lignes")
public class TransactionFournisseurLignePageController {

    private final TransactionFournisseurLigneService transactionFournisseurLigneService;
    private final FournisseurService fournisseurService;
    private final TransactionFournisseurService transactionFournisseurService;
    private final ProduitService produitService;

    public TransactionFournisseurLignePageController(TransactionFournisseurLigneService transactionFournisseurLigneService,
                                                     FournisseurService fournisseurService,
                                                     TransactionFournisseurService transactionFournisseurService,
                                                     ProduitService produitService) {
        this.transactionFournisseurLigneService = transactionFournisseurLigneService;
        this.fournisseurService = fournisseurService;
        this.transactionFournisseurService = transactionFournisseurService;
        this.produitService = produitService;
    }

    @GetMapping
    public String lignes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("lignes", transactionFournisseurLigneService.findAll());
        model.addAttribute("fournisseurs", fournisseurService.findAll());
        model.addAttribute("transactions", transactionFournisseurService.findAll());
        model.addAttribute("produits", produitService.findAll());
        TransactionFournisseurLigneDTO edit = (editId != null) ? transactionFournisseurLigneService.findById(editId) : null;
        model.addAttribute("editLigne", edit);
        return "fournisseur/transaction-lignes";
    }

    @PostMapping("/save")
    public String saveLigne(@ModelAttribute TransactionFournisseurLigneDTO dto) {
        if (dto.getId() != null) {
            transactionFournisseurLigneService.update(dto.getId(), dto);
        } else {
            transactionFournisseurLigneService.save(dto);
        }
        return "redirect:/fournisseurs/lignes";
    }

    @PostMapping("/delete/{id}")
    public String deleteLigne(@PathVariable Integer id) {
        transactionFournisseurLigneService.delete(id);
        return "redirect:/fournisseurs/lignes";
    }
}