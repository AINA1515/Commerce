package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.entity.TypePayement;
import mg.aina.commerce.commande.service.TypePayementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de paiement" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/types-payement")
public class TypePayementPageController {

    private final TypePayementService typePayementService;

    public TypePayementPageController(TypePayementService typePayementService) {
        this.typePayementService = typePayementService;
    }

    @GetMapping
    public String typePayements(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesPayement", typePayementService.findAll());
        model.addAttribute("editTypePayement", (editId != null) ? typePayementService.findById(editId) : null);
        return "commande/type-payements";
    }

    @PostMapping("/save")
    public String saveTypePayement(@ModelAttribute TypePayement entity) {
        if (entity.getId() != null) {
            typePayementService.update(entity.getId(), entity);
        } else {
            typePayementService.save(entity);
        }
        return "redirect:/commandes/types-payement";
    }

    @PostMapping("/delete/{id}")
    public String deleteTypePayement(@PathVariable Integer id) {
        typePayementService.delete(id);
        return "redirect:/commandes/types-payement";
    }
}