package mg.aina.commerce.remise.controller;

import java.sql.Timestamp;

import mg.aina.commerce.controller.TimestampEditor;
import mg.aina.commerce.remise.dto.HistoriqueRemiseDTO;
import mg.aina.commerce.remise.service.HistoriqueRemiseService;
import mg.aina.commerce.remise.service.TypeChangementRemiseService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Historique des remises" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/remises/historique")
public class HistoriqueRemisePageController {

    private final HistoriqueRemiseService historiqueRemiseService;
    private final UtilisateurService utilisateurService;
    private final TypeChangementRemiseService typeChangementRemiseService;

    public HistoriqueRemisePageController(HistoriqueRemiseService historiqueRemiseService,
                                          UtilisateurService utilisateurService,
                                          TypeChangementRemiseService typeChangementRemiseService) {
        this.historiqueRemiseService = historiqueRemiseService;
        this.utilisateurService = utilisateurService;
        this.typeChangementRemiseService = typeChangementRemiseService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
    }

    @GetMapping
    public String historique(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("historiques", historiqueRemiseService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("typesChangement", typeChangementRemiseService.findAll());
        HistoriqueRemiseDTO edit = (editId != null) ? historiqueRemiseService.findById(editId) : null;
        model.addAttribute("editHistorique", edit);
        return "remise/historique";
    }

    @PostMapping("/save")
    public String saveHistorique(@ModelAttribute HistoriqueRemiseDTO dto) {
        if (dto.getId() != null) {
            historiqueRemiseService.update(dto.getId(), dto);
        } else {
            historiqueRemiseService.save(dto);
        }
        return "redirect:/remises/historique";
    }

    @PostMapping("/delete/{id}")
    public String deleteHistorique(@PathVariable Integer id) {
        historiqueRemiseService.delete(id);
        return "redirect:/remises/historique";
    }
}