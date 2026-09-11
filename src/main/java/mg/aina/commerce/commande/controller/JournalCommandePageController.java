package mg.aina.commerce.commande.controller;

import mg.aina.commerce.client.service.ClientService;
import mg.aina.commerce.commande.dto.JournalCommandeDTO;
import mg.aina.commerce.commande.service.CommandeService;
import mg.aina.commerce.commande.service.JournalCommandeService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Journal des commandes" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/journal")
public class JournalCommandePageController {

    private final JournalCommandeService journalCommandeService;
    private final CommandeService commandeService;
    private final ClientService clientService;
    private final UtilisateurService utilisateurService;

    public JournalCommandePageController(JournalCommandeService journalCommandeService,
                                         CommandeService commandeService,
                                         ClientService clientService,
                                         UtilisateurService utilisateurService) {
        this.journalCommandeService = journalCommandeService;
        this.commandeService = commandeService;
        this.clientService = clientService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String journalCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("journals", journalCommandeService.findAll());
        model.addAttribute("commandes", commandeService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("editJournal", (editId != null) ? journalCommandeService.findById(editId) : null);
        return "commande/journal-commandes";
    }

    @PostMapping("/save")
    public String saveJournalCommande(@ModelAttribute JournalCommandeDTO dto) {
        if (dto.getId() != null) {
            journalCommandeService.update(dto.getId(), dto);
        } else {
            journalCommandeService.save(dto);
        }
        return "redirect:/commandes/journal";
    }

    @PostMapping("/delete/{id}")
    public String deleteJournalCommande(@PathVariable Integer id) {
        journalCommandeService.delete(id);
        return "redirect:/commandes/journal";
    }
}