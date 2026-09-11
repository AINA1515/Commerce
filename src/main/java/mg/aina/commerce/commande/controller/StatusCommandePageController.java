package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.StatusCommande;
import mg.aina.commerce.commande.service.StatusCommandeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Statuts de commande" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/status")
public class StatusCommandePageController {

    private final StatusCommandeService statusCommandeService;

    public StatusCommandePageController(StatusCommandeService statusCommandeService) {
        this.statusCommandeService = statusCommandeService;
    }

    @GetMapping
    public String statusCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("statusCommandes", statusCommandeService.findAll());
        model.addAttribute("editStatusCommande", (editId != null) ? statusCommandeService.findById(editId) : null);
        return "commande/status-commandes";
    }

    @PostMapping("/save")
    public String saveStatusCommande(@ModelAttribute StatusCommande entity) {
        if (entity.getId() != null) {
            statusCommandeService.update(entity.getId(), entity);
        } else {
            statusCommandeService.save(entity);
        }
        return "redirect:/commandes/status";
    }

    @PostMapping("/delete/{id}")
    public String deleteStatusCommande(@PathVariable Integer id) {
        statusCommandeService.delete(id);
        return "redirect:/commandes/status";
    }
}