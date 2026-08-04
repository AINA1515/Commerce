package mg.aina.commerce.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Page d'accueil (tableau de bord). Ne fait que renvoyer la vue : les donnees
 * affichees sur chaque page sont chargees cote client via les API REST existantes.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
