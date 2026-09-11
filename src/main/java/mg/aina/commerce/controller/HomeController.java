package mg.aina.commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Page d'accueil (tableau de bord). Renvoie la vue index rendue cote serveur
 * (Thymeleaf).
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}