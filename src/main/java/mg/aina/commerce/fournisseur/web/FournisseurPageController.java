package mg.aina.commerce.fournisseur.web;

import mg.aina.commerce.fournisseur.dto.FournisseurDTO;
import mg.aina.commerce.fournisseur.dto.TransactionFournisseurDTO;
import mg.aina.commerce.fournisseur.dto.TransactionFournisseurLigneDTO;
import mg.aina.commerce.fournisseur.dto.TypeTransactionFournisseurDTO;
import mg.aina.commerce.fournisseur.service.FournisseurService;
import mg.aina.commerce.fournisseur.service.TransactionFournisseurLigneService;
import mg.aina.commerce.fournisseur.service.TransactionFournisseurService;
import mg.aina.commerce.fournisseur.service.TypeTransactionFournisseurService;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
 */
@Controller
@RequestMapping("/fournisseurs")
public class FournisseurPageController {

    private final FournisseurService fournisseurService;
    private final TypeTransactionFournisseurService typeTransactionFournisseurService;
    private final TransactionFournisseurService transactionFournisseurService;
    private final TransactionFournisseurLigneService transactionFournisseurLigneService;
    private final ProduitService produitService;
    private final UtilisateurService utilisateurService;

    public FournisseurPageController(FournisseurService fournisseurService,
                                     TypeTransactionFournisseurService typeTransactionFournisseurService,
                                     TransactionFournisseurService transactionFournisseurService,
                                     TransactionFournisseurLigneService transactionFournisseurLigneService,
                                     ProduitService produitService,
                                     UtilisateurService utilisateurService) {
        this.fournisseurService = fournisseurService;
        this.typeTransactionFournisseurService = typeTransactionFournisseurService;
        this.transactionFournisseurService = transactionFournisseurService;
        this.transactionFournisseurLigneService = transactionFournisseurLigneService;
        this.produitService = produitService;
        this.utilisateurService = utilisateurService;
    }

    // --- Fournisseurs ---

    @GetMapping
    public String fournisseurs(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("fournisseurs", fournisseurService.findAll());
        FournisseurDTO edit = (editId != null) ? fournisseurService.findById(editId) : null;
        model.addAttribute("editFournisseur", edit);
        return "fournisseur/fournisseurs";
    }

    @PostMapping("/save")
    public String saveFournisseur(@ModelAttribute FournisseurDTO dto) {
        if (dto.getId() != null) {
            fournisseurService.update(dto.getId(), dto);
        } else {
            fournisseurService.save(dto);
        }
        return "redirect:/fournisseurs";
    }

    @PostMapping("/delete/{id}")
    public String deleteFournisseur(@PathVariable Integer id) {
        fournisseurService.delete(id);
        return "redirect:/fournisseurs";
    }

    // --- Types de transaction fournisseur ---

    @GetMapping("/types")
    public String typesTransaction(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesTransaction", typeTransactionFournisseurService.findAll());
        TypeTransactionFournisseurDTO edit = (editId != null) ? typeTransactionFournisseurService.findById(editId) : null;
        model.addAttribute("editTypeTransaction", edit);
        return "fournisseur/types-transaction";
    }

    @PostMapping("/types/save")
    public String saveTypeTransaction(@ModelAttribute TypeTransactionFournisseurDTO dto) {
        if (dto.getId() != null) {
            typeTransactionFournisseurService.update(dto.getId(), dto);
        } else {
            typeTransactionFournisseurService.save(dto);
        }
        return "redirect:/fournisseurs/types";
    }

    @PostMapping("/types/delete/{id}")
    public String deleteTypeTransaction(@PathVariable Integer id) {
        typeTransactionFournisseurService.delete(id);
        return "redirect:/fournisseurs/types";
    }

    // --- Transactions fournisseur ---

    @GetMapping("/transactions")
    public String transactions(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("transactions", transactionFournisseurService.findAll());
        model.addAttribute("typesTransaction", typeTransactionFournisseurService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        TransactionFournisseurDTO edit = (editId != null) ? transactionFournisseurService.findById(editId) : null;
        model.addAttribute("editTransaction", edit);
        return "fournisseur/transactions";
    }

    @PostMapping("/transactions/save")
    public String saveTransaction(@ModelAttribute TransactionFournisseurDTO dto) {
        if (dto.getId() != null) {
            transactionFournisseurService.update(dto.getId(), dto);
        } else {
            transactionFournisseurService.save(dto);
        }
        return "redirect:/fournisseurs/transactions";
    }

    @PostMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable Integer id) {
        transactionFournisseurService.delete(id);
        return "redirect:/fournisseurs/transactions";
    }

    // --- Lignes de transaction fournisseur ---

    @GetMapping("/lignes")
    public String lignes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("lignes", transactionFournisseurLigneService.findAll());
        model.addAttribute("fournisseurs", fournisseurService.findAll());
        model.addAttribute("transactions", transactionFournisseurService.findAll());
        model.addAttribute("produits", produitService.findAll());
        TransactionFournisseurLigneDTO edit = (editId != null) ? transactionFournisseurLigneService.findById(editId) : null;
        model.addAttribute("editLigne", edit);
        return "fournisseur/transaction-lignes";
    }

    @PostMapping("/lignes/save")
    public String saveLigne(@ModelAttribute TransactionFournisseurLigneDTO dto) {
        if (dto.getId() != null) {
            transactionFournisseurLigneService.update(dto.getId(), dto);
        } else {
            transactionFournisseurLigneService.save(dto);
        }
        return "redirect:/fournisseurs/lignes";
    }

    @PostMapping("/lignes/delete/{id}")
    public String deleteLigne(@PathVariable Integer id) {
        transactionFournisseurLigneService.delete(id);
        return "redirect:/fournisseurs/lignes";
    }
}
