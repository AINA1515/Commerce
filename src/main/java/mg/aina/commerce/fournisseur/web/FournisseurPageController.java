package mg.aina.commerce.fournisseur.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par les
 * controleurs REST de mg.aina.commerce.fournisseur.controller.
 */
@Controller
public class FournisseurPageController {

    @GetMapping("/fournisseurs")
    public String fournisseurs() {
        return "fournisseur/fournisseurs";
    }

    @GetMapping("/fournisseurs/types-transaction")
    public String typesTransaction() {
        return "fournisseur/types-transaction";
    }

    @GetMapping("/fournisseurs/transactions")
    public String transactions() {
        return "fournisseur/transactions";
    }

    @GetMapping("/fournisseurs/transactions/lignes")
    public String transactionLignes() {
        return "fournisseur/transaction-lignes";
    }
}
