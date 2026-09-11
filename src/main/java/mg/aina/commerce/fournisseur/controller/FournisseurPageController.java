package mg.aina.commerce.fournisseur.controller;

import mg.aina.commerce.fournisseur.dto.FournisseurDTO;
import mg.aina.commerce.fournisseur.service.FournisseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Fournisseurs" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/fournisseurs")
public class FournisseurPageController {

    private final FournisseurService fournisseurService;

    public FournisseurPageController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public String fournisseurs(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("fournisseurs", fournisseurService.findAll());
        FournisseurDTO edit = (editId != null) ? fournisseurService.findById(editId) : null;
        model.addAttribute("editFournisseur", edit);
        return "fournisseur/fournisseurs";
    }

    @PostMapping("/save")
    public String saveFournisseur(@ModelAttribute FournisseurDTO dto) {
        if (dto.getId() != null) {
            fournisseurService.update(dto.getId(), dto);
        } else {
            fournisseurService.save(dto);
        }
        return "redirect:/fournisseurs";
    }

    @PostMapping("/delete/{id}")
    public String deleteFournisseur(@PathVariable Integer id) {
        fournisseurService.delete(id);
        return "redirect:/fournisseurs";
    }
}