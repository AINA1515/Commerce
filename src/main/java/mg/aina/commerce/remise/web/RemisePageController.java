package mg.aina.commerce.remise.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par les
 * controleurs REST de mg.aina.commerce.remise.controller.
 */
@Controller
public class RemisePageController {

    @GetMapping("/remises")
    public String remises() {
        return "remise/remises";
    }

    @GetMapping("/remises/historique")
    public String historique() {
        return "remise/historique";
    }

    @GetMapping("/remises/types-changement")
    public String typesChangement() {
        return "remise/types-changement";
    }
}
