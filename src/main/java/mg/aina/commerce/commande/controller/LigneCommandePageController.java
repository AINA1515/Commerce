package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.dto.LigneCommandeDTO;
import mg.aina.commerce.commande.service.CommandeService;
import mg.aina.commerce.commande.service.LigneCommandeService;
import mg.aina.commerce.commande.service.StatusLigneCommandeService;
import mg.aina.commerce.produit.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Lignes de commande" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/lignes")
public class LigneCommandePageController {

    private final LigneCommandeService ligneCommandeService;
    private final CommandeService commandeService;
    private final ProduitService produitService;
    private final StatusLigneCommandeService statusLigneCommandeService;

    public LigneCommandePageController(LigneCommandeService ligneCommandeService,
                                       CommandeService commandeService,
                                       ProduitService produitService,
                                       StatusLigneCommandeService statusLigneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
        this.commandeService = commandeService;
        this.produitService = produitService;
        this.statusLigneCommandeService = statusLigneCommandeService;
    }

    @GetMapping
    public String lignes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("lignes", ligneCommandeService.findAll());
        model.addAttribute("commandes", commandeService.findAll());
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("statusLigne", statusLigneCommandeService.findAll());
        model.addAttribute("editLigne", (editId != null) ? ligneCommandeService.findById(editId) : null);
        return "commande/lignes";
    }

    @PostMapping("/save")
    public String saveLigne(@ModelAttribute LigneCommandeDTO dto) {
        if (dto.getId() != null) {
            ligneCommandeService.update(dto.getId(), dto);
        } else {
            ligneCommandeService.save(dto);
        }
        return "redirect:/commandes/lignes";
    }

    @PostMapping("/delete/{id}")
    public String deleteLigne(@PathVariable Integer id) {
        ligneCommandeService.delete(id);
        return "redirect:/commandes/lignes";
    }
}