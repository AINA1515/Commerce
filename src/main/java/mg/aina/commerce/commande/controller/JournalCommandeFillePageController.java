package mg.aina.commerce.commande.controller;

import mg.aina.commerce.client.service.ClientService;
import mg.aina.commerce.commande.dto.JournalCommandeFilleDTO;
import mg.aina.commerce.commande.service.JournalCommandeFilleService;
import mg.aina.commerce.commande.service.LigneCommandeService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Journal des commandes filles" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/journal-filles")
public class JournalCommandeFillePageController {

    private final JournalCommandeFilleService journalCommandeFilleService;
    private final LigneCommandeService ligneCommandeService;
    private final ClientService clientService;
    private final UtilisateurService utilisateurService;

    public JournalCommandeFillePageController(JournalCommandeFilleService journalCommandeFilleService,
                                              LigneCommandeService ligneCommandeService,
                                              ClientService clientService,
                                              UtilisateurService utilisateurService) {
        this.journalCommandeFilleService = journalCommandeFilleService;
        this.ligneCommandeService = ligneCommandeService;
        this.clientService = clientService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String journalFilles(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("journalFilles", journalCommandeFilleService.findAll());
        model.addAttribute("lignes", ligneCommandeService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("editJournalFille", (editId != null) ? journalCommandeFilleService.findById(editId) : null);
        return "commande/journal-commande-filles";
    }

    @PostMapping("/save")
    public String saveJournalFille(@ModelAttribute JournalCommandeFilleDTO dto) {
        if (dto.getId() != null) {
            journalCommandeFilleService.update(dto.getId(), dto);
        } else {
            journalCommandeFilleService.save(dto);
        }
        return "redirect:/commandes/journal-filles";
    }

    @PostMapping("/delete/{id}")
    public String deleteJournalFille(@PathVariable Integer id) {
        journalCommandeFilleService.delete(id);
        return "redirect:/commandes/journal-filles";
    }
}