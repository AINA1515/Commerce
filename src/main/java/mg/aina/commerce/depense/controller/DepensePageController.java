package mg.aina.commerce.depense.controller;

import mg.aina.commerce.depense.dto.HistoriqueDepenseDTO;
import mg.aina.commerce.depense.service.HistoriqueDepenseService;
import mg.aina.commerce.depense.service.TypeDepenseService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Historique des depenses" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/depenses")
public class DepensePageController {

    private final HistoriqueDepenseService historiqueDepenseService;
    private final TypeDepenseService typeDepenseService;
    private final UtilisateurService utilisateurService;

    public DepensePageController(HistoriqueDepenseService historiqueDepenseService,
                                 TypeDepenseService typeDepenseService,
                                 UtilisateurService utilisateurService) {
        this.historiqueDepenseService = historiqueDepenseService;
        this.typeDepenseService = typeDepenseService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String historique(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("historiques", historiqueDepenseService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("typesDepense", typeDepenseService.findAll());
        HistoriqueDepenseDTO edit = (editId != null) ? historiqueDepenseService.findById(editId) : null;
        model.addAttribute("editHistorique", edit);
        return "depense/historique";
    }

    @PostMapping("/save")
    public String saveHistorique(@ModelAttribute HistoriqueDepenseDTO dto) {
        if (dto.getId() != null) {
            historiqueDepenseService.update(dto.getId(), dto);
        } else {
            historiqueDepenseService.save(dto);
        }
        return "redirect:/depenses";
    }

    @PostMapping("/delete/{id}")
    public String deleteHistorique(@PathVariable Integer id) {
        historiqueDepenseService.delete(id);
        return "redirect:/depenses";
    }
}