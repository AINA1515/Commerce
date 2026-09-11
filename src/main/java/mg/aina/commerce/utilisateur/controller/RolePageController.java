package mg.aina.commerce.utilisateur.controller;

import mg.aina.commerce.utilisateur.dto.RoleDTO;
import mg.aina.commerce.utilisateur.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Roles" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/utilisateurs/roles")
public class RolePageController {

    private final RoleService roleService;

    public RolePageController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String roles(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("roles", roleService.findAll());
        RoleDTO edit = (editId != null) ? roleService.findById(editId) : null;
        model.addAttribute("editRole", edit);
        return "utilisateur/roles";
    }

    @PostMapping("/save")
    public String saveRole(@ModelAttribute RoleDTO dto) {
        if (dto.getId() != null) {
            roleService.update(dto.getId(), dto);
        } else {
            roleService.save(dto);
        }
        return "redirect:/utilisateurs/roles";
    }

    @PostMapping("/delete/{id}")
    public String deleteRole(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/utilisateurs/roles";
    }
}