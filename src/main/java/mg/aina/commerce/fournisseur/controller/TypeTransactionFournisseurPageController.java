package mg.aina.commerce.fournisseur.controller;

import mg.aina.commerce.fournisseur.dto.TypeTransactionFournisseurDTO;
import mg.aina.commerce.fournisseur.service.TypeTransactionFournisseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Types de transaction fournisseur" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/fournisseurs/types")
public class TypeTransactionFournisseurPageController {

    private final TypeTransactionFournisseurService typeTransactionFournisseurService;

    public TypeTransactionFournisseurPageController(TypeTransactionFournisseurService typeTransactionFournisseurService) {
        this.typeTransactionFournisseurService = typeTransactionFournisseurService;
    }

    @GetMapping
    public String typesTransaction(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesTransaction", typeTransactionFournisseurService.findAll());
        TypeTransactionFournisseurDTO edit = (editId != null) ? typeTransactionFournisseurService.findById(editId) : null;
        model.addAttribute("editTypeTransaction", edit);
        return "fournisseur/types-transaction";
    }

    @PostMapping("/save")
    public String saveTypeTransaction(@ModelAttribute TypeTransactionFournisseurDTO dto) {
        if (dto.getId() != null) {
            typeTransactionFournisseurService.update(dto.getId(), dto);
        } else {
            typeTransactionFournisseurService.save(dto);
        }
        return "redirect:/fournisseurs/types";
    }

    @PostMapping("/delete/{id}")
    public String deleteTypeTransaction(@PathVariable Integer id) {
        typeTransactionFournisseurService.delete(id);
        return "redirect:/fournisseurs/types";
    }
}