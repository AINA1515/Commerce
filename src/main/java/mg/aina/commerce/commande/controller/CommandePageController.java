package mg.aina.commerce.commande.controller;

import mg.aina.commerce.client.service.ClientService;
import mg.aina.commerce.commande.dto.CommandeDTO;
import mg.aina.commerce.commande.service.CommandeService;
import mg.aina.commerce.commande.service.TypeTransactionCommandeService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Commandes" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes")
public class CommandePageController {

    private final CommandeService commandeService;
    private final TypeTransactionCommandeService typeTransactionCommandeService;
    private final ClientService clientService;
    private final UtilisateurService utilisateurService;

    public CommandePageController(CommandeService commandeService,
                                  TypeTransactionCommandeService typeTransactionCommandeService,
                                  ClientService clientService,
                                  UtilisateurService utilisateurService) {
        this.commandeService = commandeService;
        this.typeTransactionCommandeService = typeTransactionCommandeService;
        this.clientService = clientService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String commandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("commandes", commandeService.findAll());
        model.addAttribute("typesTransaction", typeTransactionCommandeService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("editCommande", (editId != null) ? commandeService.findById(editId) : null);
        return "commande/commandes";
    }

    @PostMapping("/save")
    public String saveCommande(@ModelAttribute CommandeDTO dto) {
        if (dto.getId() != null) {
            commandeService.update(dto.getId(), dto);
        } else {
            commandeService.save(dto);
        }
        return "redirect:/commandes";
    }

    @PostMapping("/delete/{id}")
    public String deleteCommande(@PathVariable Integer id) {
        commandeService.delete(id);
        return "redirect:/commandes";
    }
}