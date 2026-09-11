package mg.aina.commerce.caisse.web;

import mg.aina.commerce.caisse.entity.Caisse;
import mg.aina.commerce.caisse.service.CaisseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
 */
@Controller
@RequestMapping("/caisse")
public class CaissePageController {

    private final CaisseService caisseService;

    public CaissePageController(CaisseService caisseService) {
        this.caisseService = caisseService;
    }

    @GetMapping
    public String caisse(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("caisses", caisseService.findAll());
        Caisse edit = (editId != null) ? caisseService.findById(editId) : null;
        model.addAttribute("editCaisse", edit);
        return "caisse/caisse";
    }

    @PostMapping("/save")
    public String saveCaisse(@ModelAttribute Caisse entity) {
        if (entity.getId() != null) {
            caisseService.update(entity.getId(), entity);
        } else {
            caisseService.save(entity);
        }
        return "redirect:/caisse";
    }

    @PostMapping("/delete/{id}")
    public String deleteCaisse(@PathVariable Integer id) {
        caisseService.delete(id);
        return "redirect:/caisse";
    }
}
