package mg.aina.commerce.utilisateur.controller;

import mg.aina.commerce.utilisateur.dto.UtilisateurDTO;
import mg.aina.commerce.utilisateur.service.RoleService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Utilisateurs" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurPageController {

    private final UtilisateurService utilisateurService;
    private final RoleService roleService;

    public UtilisateurPageController(UtilisateurService utilisateurService, RoleService roleService) {
        this.utilisateurService = utilisateurService;
        this.roleService = roleService;
    }

    @GetMapping
    public String utilisateurs(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("roles", roleService.findAll());
        UtilisateurDTO edit = (editId != null) ? utilisateurService.findById(editId) : null;
        model.addAttribute("editUtilisateur", edit);
        return "utilisateur/utilisateurs";
    }

    @PostMapping("/save")
    public String saveUtilisateur(@ModelAttribute UtilisateurDTO dto) {
        if (dto.getId() != null) {
            utilisateurService.update(dto.getId(), dto);
        } else {
            utilisateurService.save(dto);
        }
        return "redirect:/utilisateurs";
    }

    @PostMapping("/delete/{id}")
    public String deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.delete(id);
        return "redirect:/utilisateurs";
    }
}