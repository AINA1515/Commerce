package mg.aina.commerce.fournisseur.controller;

import mg.aina.commerce.fournisseur.dto.TransactionFournisseurDTO;
import mg.aina.commerce.fournisseur.service.TransactionFournisseurService;
import mg.aina.commerce.fournisseur.service.TypeTransactionFournisseurService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Transactions fournisseur" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/fournisseurs/transactions")
public class TransactionFournisseurPageController {

    private final TransactionFournisseurService transactionFournisseurService;
    private final TypeTransactionFournisseurService typeTransactionFournisseurService;
    private final UtilisateurService utilisateurService;

    public TransactionFournisseurPageController(TransactionFournisseurService transactionFournisseurService,
                                                TypeTransactionFournisseurService typeTransactionFournisseurService,
                                                UtilisateurService utilisateurService) {
        this.transactionFournisseurService = transactionFournisseurService;
        this.typeTransactionFournisseurService = typeTransactionFournisseurService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String transactions(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("transactions", transactionFournisseurService.findAll());
        model.addAttribute("typesTransaction", typeTransactionFournisseurService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        TransactionFournisseurDTO edit = (editId != null) ? transactionFournisseurService.findById(editId) : null;
        model.addAttribute("editTransaction", edit);
        return "fournisseur/transactions";
    }

    @PostMapping("/save")
    public String saveTransaction(@ModelAttribute TransactionFournisseurDTO dto) {
        if (dto.getId() != null) {
            transactionFournisseurService.update(dto.getId(), dto);
        } else {
            transactionFournisseurService.save(dto);
        }
        return "redirect:/fournisseurs/transactions";
    }

    @PostMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Integer id) {
        transactionFournisseurService.delete(id);
        return "redirect:/fournisseurs/transactions";
    }
}