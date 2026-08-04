package mg.aina.commerce.depense.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par les
 * controleurs REST de mg.aina.commerce.depense.controller.
 */
@Controller
public class DepensePageController {

    @GetMapping("/depenses")
    public String historique() {
        return "depense/historique";
    }

    @GetMapping("/depenses/types")
    public String types() {
        return "depense/types";
    }
}
