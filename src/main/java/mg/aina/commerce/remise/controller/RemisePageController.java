package mg.aina.commerce.remise.controller;

import java.sql.Timestamp;

import mg.aina.commerce.controller.TimestampEditor;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.remise.dto.RemiseDTO;
import mg.aina.commerce.remise.service.RemiseService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Remises" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/remises")
public class RemisePageController {

    private final RemiseService remiseService;
    private final UtilisateurService utilisateurService;
    private final ProduitService produitService;

    public RemisePageController(RemiseService remiseService,
                                UtilisateurService utilisateurService,
                                ProduitService produitService) {
        this.remiseService = remiseService;
        this.utilisateurService = utilisateurService;
        this.produitService = produitService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
    }

    @GetMapping
    public String remises(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("remises", remiseService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("produits", produitService.findAll());
        RemiseDTO edit = (editId != null) ? remiseService.findById(editId) : null;
        model.addAttribute("editRemise", edit);
        return "remise/remises";
    }

    @PostMapping("/save")
    public String saveRemise(@ModelAttribute RemiseDTO dto) {
        if (dto.getId() != null) {
            remiseService.update(dto.getId(), dto);
        } else {
            remiseService.save(dto);
        }
        return "redirect:/remises";
    }

    @PostMapping("/delete/{id}")
    public String deleteRemise(@PathVariable Integer id) {
        remiseService.delete(id);
        return "redirect:/remises";
    }
}