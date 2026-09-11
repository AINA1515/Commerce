package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.TypeTransactionCommande;
import mg.aina.commerce.commande.service.TypeTransactionCommandeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de transaction commande" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/types-transaction")
public class TypeTransactionCommandePageController {

    private final TypeTransactionCommandeService typeTransactionCommandeService;

    public TypeTransactionCommandePageController(TypeTransactionCommandeService typeTransactionCommandeService) {
        this.typeTransactionCommandeService = typeTransactionCommandeService;
    }

    @GetMapping
    public String typeTransactionCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesTransaction", typeTransactionCommandeService.findAll());
        model.addAttribute("editTypeTransaction", (editId != null) ? typeTransactionCommandeService.findById(editId) : null);
        return "commande/type-transaction-commandes";
    }

    @PostMapping("/save")
    public String saveTypeTransactionCommande(@ModelAttribute TypeTransactionCommande entity) {
        if (entity.getId() != null) {
            typeTransactionCommandeService.update(entity.getId(), entity);
        } else {
            typeTransactionCommandeService.save(entity);
        }
        return "redirect:/commandes/types-transaction";
    }

    @PostMapping("/delete/{id}")
    public String deleteTypeTransactionCommande(@PathVariable Integer id) {
        typeTransactionCommandeService.delete(id);
        return "redirect:/commandes/types-transaction";
    }
}