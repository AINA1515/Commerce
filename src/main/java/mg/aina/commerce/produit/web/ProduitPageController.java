package mg.aina.commerce.produit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controleur de page (vue Thymeleaf uniquement). Le CRUD reste gere par les
 * controleurs REST de mg.aina.commerce.produit.controller.
 */
@Controller
public class ProduitPageController {

    @GetMapping("/produits")
    public String produits() {
        return "produit/produits";
    }

    @GetMapping("/produits/types")
    public String types() {
        return "produit/types-produit";
    }

    @GetMapping("/produits/stocks")
    public String stocks() {
        return "produit/stocks";
    }

    @GetMapping("/produits/journal-stocks")
    public String journalStocks() {
        return "produit/journal-stocks";
    }

    @GetMapping("/produits/types-transaction-stock")
    public String typesTransactionStock() {
        return "produit/types-transaction-stock";
    }
}
