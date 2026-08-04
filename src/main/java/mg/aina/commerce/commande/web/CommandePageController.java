package mg.aina.commerce.commande.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par les
 * controleurs REST de mg.aina.commerce.commande.controller.
 */
@Controller
public class CommandePageController {

    @GetMapping("/commandes")
    public String commandes() {
        return "commande/commandes";
    }

    @GetMapping("/commandes/lignes")
    public String lignes() {
        return "commande/lignes";
    }

    @GetMapping("/commandes/journal")
    public String journal() {
        return "commande/journal-commandes";
    }

    @GetMapping("/commandes/journal-filles")
    public String journalFilles() {
        return "commande/journal-commande-filles";
    }

    @GetMapping("/commandes/payements")
    public String payements() {
        return "commande/payements";
    }

    @GetMapping("/commandes/status")
    public String status() {
        return "commande/status-commandes";
    }

    @GetMapping("/commandes/status-ligne")
    public String statusLigne() {
        return "commande/status-ligne-commandes";
    }

    @GetMapping("/commandes/types-payement")
    public String typesPayement() {
        return "commande/type-payements";
    }

    @GetMapping("/commandes/types-transaction")
    public String typesTransaction() {
        return "commande/type-transaction-commandes";
    }
}
