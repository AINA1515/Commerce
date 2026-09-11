package mg.aina.commerce.remise.controller;

import mg.aina.commerce.remise.entity.TypeChangementRemise;
import mg.aina.commerce.remise.service.TypeChangementRemiseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de changement de remise" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/remises/types-changement")
public class TypeChangementRemisePageController {

    private final TypeChangementRemiseService typeChangementRemiseService;

    public TypeChangementRemisePageController(TypeChangementRemiseService typeChangementRemiseService) {
        this.typeChangementRemiseService = typeChangementRemiseService;
    }

    @GetMapping
    public String typesChangement(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesChangement", typeChangementRemiseService.findAll());
        TypeChangementRemise edit = (editId != null) ? typeChangementRemiseService.findById(editId) : null;
        model.addAttribute("editTypeChangement", edit);
        return "remise/types-changement";
    }

    @PostMapping("/save")
    public String saveTypeChangement(@ModelAttribute TypeChangementRemise entity) {
        if (entity.getId() != null) {
            typeChangementRemiseService.update(entity.getId(), entity);
        } else {
            typeChangementRemiseService.save(entity);
        }
        return "redirect:/remises/types-changement";
    }

    @PostMapping("/delete/{id}")
    public String deleteTypeChangement(@PathVariable Integer id) {
        typeChangementRemiseService.delete(id);
        return "redirect:/remises/types-changement";
    }
}