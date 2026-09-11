package mg.aina.commerce.depense.controller;

import mg.aina.commerce.depense.entity.TypeDepense;
import mg.aina.commerce.depense.service.TypeDepenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de depense" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/depenses/types")
public class TypeDepensePageController {

    private final TypeDepenseService typeDepenseService;

    public TypeDepensePageController(TypeDepenseService typeDepenseService) {
        this.typeDepenseService = typeDepenseService;
    }

    @GetMapping
    public String types(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesDepense", typeDepenseService.findAll());
        TypeDepense edit = (editId != null) ? typeDepenseService.findById(editId) : null;
        model.addAttribute("editTypeDepense", edit);
        return "depense/types";
    }

    @PostMapping("/save")
    public String saveType(@ModelAttribute TypeDepense entity) {
        if (entity.getId() != null) {
            typeDepenseService.update(entity.getId(), entity);
        } else {
            typeDepenseService.save(entity);
        }
        return "redirect:/depenses/types";
    }

    @PostMapping("/delete/{id}")
    public String deleteType(@PathVariable Integer id) {
        typeDepenseService.delete(id);
        return "redirect:/depenses/types";
    }
}