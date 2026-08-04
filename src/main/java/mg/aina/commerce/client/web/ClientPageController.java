package mg.aina.commerce.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par
 * mg.aina.commerce.client.controller.ClientController (API REST).
 */
@Controller
public class ClientPageController {

    @GetMapping("/clients")
    public String clients() {
        return "client/clients";
    }
}
