package mg.aina.commerce.depense.web;

import mg.aina.commerce.depense.dto.HistoriqueDepenseDTO;
import mg.aina.commerce.depense.entity.TypeDepense;
import mg.aina.commerce.depense.service.HistoriqueDepenseService;
import mg.aina.commerce.depense.service.TypeDepenseService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
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

    // --- Historique des depenses ---

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

    // --- Types de depense ---

    @GetMapping("/types")
    public String types(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesDepense", typeDepenseService.findAll());
        TypeDepense edit = (editId != null) ? typeDepenseService.findById(editId) : null;
        model.addAttribute("editTypeDepense", edit);
        return "depense/types";
    }

    @PostMapping("/types/save")
    public String saveType(@ModelAttribute TypeDepense entity) {
        if (entity.getId() != null) {
            typeDepenseService.update(entity.getId(), entity);
        } else {
            typeDepenseService.save(entity);
        }
        return "redirect:/depenses/types";
    }

    @PostMapping("/types/delete/{id}")
    public String deleteType(@PathVariable Integer id) {
        typeDepenseService.delete(id);
        return "redirect:/depenses/types";
    }
}
