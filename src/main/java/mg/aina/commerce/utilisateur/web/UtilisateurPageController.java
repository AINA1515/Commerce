package mg.aina.commerce.utilisateur.web;

import mg.aina.commerce.utilisateur.dto.RoleDTO;
import mg.aina.commerce.utilisateur.dto.UtilisateurDTO;
import mg.aina.commerce.utilisateur.service.RoleService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
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

    // --- Utilisateurs ---

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

    // --- Roles ---

    @GetMapping("/roles")
    public String roles(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("roles", roleService.findAll());
        RoleDTO edit = (editId != null) ? roleService.findById(editId) : null;
        model.addAttribute("editRole", edit);
        return "utilisateur/roles";
    }

    @PostMapping("/roles/save")
    public String saveRole(@ModelAttribute RoleDTO dto) {
        if (dto.getId() != null) {
            roleService.update(dto.getId(), dto);
        } else {
            roleService.save(dto);
        }
        return "redirect:/utilisateurs/roles";
    }

    @PostMapping("/roles/delete/{id}")
    public String deleteRole(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/utilisateurs/roles";
    }
}
