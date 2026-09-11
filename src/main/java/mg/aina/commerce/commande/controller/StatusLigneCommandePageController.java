package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.StatusLigneCommande;
import mg.aina.commerce.commande.service.StatusLigneCommandeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Statuts de ligne de commande" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/status-lignes")
public class StatusLigneCommandePageController {

    private final StatusLigneCommandeService statusLigneCommandeService;

    public StatusLigneCommandePageController(StatusLigneCommandeService statusLigneCommandeService) {
        this.statusLigneCommandeService = statusLigneCommandeService;
    }

    @GetMapping
    public String statusLigneCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("statusLignes", statusLigneCommandeService.findAll());
        model.addAttribute("editStatusLigne", (editId != null) ? statusLigneCommandeService.findById(editId) : null);
        return "commande/status-ligne-commandes";
    }

    @PostMapping("/save")
    public String saveStatusLigneCommande(@ModelAttribute StatusLigneCommande entity) {
        if (entity.getId() != null) {
            statusLigneCommandeService.update(entity.getId(), entity);
        } else {
            statusLigneCommandeService.save(entity);
        }
        return "redirect:/commandes/status-lignes";
    }

    @PostMapping("/delete/{id}")
    public String deleteStatusLigneCommande(@PathVariable Integer id) {
        statusLigneCommandeService.delete(id);
        return "redirect:/commandes/status-lignes";
    }
}