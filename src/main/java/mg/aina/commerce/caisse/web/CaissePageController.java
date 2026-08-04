package mg.aina.commerce.caisse.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par
 * mg.aina.commerce.caisse.controller.CaisseController (API REST).
 */
@Controller
public class CaissePageController {

    @GetMapping("/caisse")
    public String caisse() {
        return "caisse/caisse";
    }
}
