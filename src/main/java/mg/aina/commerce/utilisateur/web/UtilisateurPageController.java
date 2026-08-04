package mg.aina.commerce.utilisateur.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par les
 * controleurs REST de mg.aina.commerce.utilisateur.controller.
 */
@Controller
public class UtilisateurPageController {

    @GetMapping("/utilisateurs")
    public String utilisateurs() {
        return "utilisateur/utilisateurs";
    }

    @GetMapping("/utilisateurs/roles")
    public String roles() {
        return "utilisateur/roles";
    }
}
