package mg.aina.commerce.produit.web;

import mg.aina.commerce.produit.dto.JournalStockDTO;
import mg.aina.commerce.produit.dto.ProduitDTO;
import mg.aina.commerce.produit.dto.StockProduitDTO;
import mg.aina.commerce.produit.dto.TypeProduitDTO;
import mg.aina.commerce.produit.dto.TypeTransactionStockDTO;
import mg.aina.commerce.produit.service.JournalStockService;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.produit.service.StockProduitService;
import mg.aina.commerce.produit.service.TypeProduitService;
import mg.aina.commerce.produit.service.TypeTransactionStockService;
import mg.aina.commerce.utilisateur.dto.UtilisateurDTO;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
 */
@Controller
@RequestMapping("/produits")
public class ProduitPageController {

    private final ProduitService produitService;
    private final TypeProduitService typeProduitService;
    private final StockProduitService stockProduitService;
    private final JournalStockService journalStockService;
    private final TypeTransactionStockService typeTransactionStockService;
    private final UtilisateurService utilisateurService;

    public ProduitPageController(ProduitService produitService,
                                 TypeProduitService typeProduitService,
                                 StockProduitService stockProduitService,
                                 JournalStockService journalStockService,
                                 TypeTransactionStockService typeTransactionStockService,
                                 UtilisateurService utilisateurService) {
        this.produitService = produitService;
        this.typeProduitService = typeProduitService;
        this.stockProduitService = stockProduitService;
        this.journalStockService = journalStockService;
        this.typeTransactionStockService = typeTransactionStockService;
        this.utilisateurService = utilisateurService;
    }
// --- Produits ---

    @GetMapping
    public String produits(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("typesProduit", typeProduitService.findAll());
        ProduitDTO edit = (editId != null) ? produitService.findById(editId) : null;
        model.addAttribute("editProduit", edit);
        return "produit/produits";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute ProduitDTO dto) {
        if (dto.getId() != null) {
            produitService.update(dto.getId(), dto);
        } else {
            produitService.save(dto);
        }
        return "redirect:/produits";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduit(@PathVariable Integer id) {
        produitService.delete(id);
        return "redirect:/produits";
    }

    // --- Types de produit ---

    @GetMapping("/types")
    public String types(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesProduit", typeProduitService.findAll());
        TypeProduitDTO edit = (editId != null) ? typeProduitService.findById(editId) : null;
        model.addAttribute("editTypeProduit", edit);
        return "produit/types-produit";
    }

    @PostMapping("/types/save")
    public String saveType(@ModelAttribute TypeProduitDTO dto) {
        if (dto.getId() != null) {
            typeProduitService.update(dto.getId(), dto);
        } else {
            typeProduitService.save(dto);
        }
        return "redirect:/produits/types";
    }

    @PostMapping("/types/delete/{id}")
    public String deleteType(@PathVariable Integer id) {
        typeProduitService.delete(id);
        return "redirect:/produits/types";
    }

    // --- Stocks ---

    @GetMapping("/stocks")
    public String stocks(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("stocks", stockProduitService.findAll());
        model.addAttribute("produits", produitService.findAll());
        StockProduitDTO edit = (editId != null) ? stockProduitService.findById(editId) : null;
        model.addAttribute("editStock", edit);
        return "produit/stocks";
    }

    @PostMapping("/stocks/save")
    public String saveStock(@ModelAttribute StockProduitDTO dto) {
        if (dto.getId() != null) {
            stockProduitService.update(dto.getId(), dto, 3);
        } else {
            stockProduitService.save(dto);
        }
        return "redirect:/produits/stocks";
    }

    @PostMapping("/stocks/delete/{id}")
    public String deleteStock(@PathVariable Integer id) {
        stockProduitService.delete(id);
        return "redirect:/produits/stocks";
    }

// --- Journal des stocks ---

    @GetMapping("/journal-stocks")
    public String journalStocks(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("journalStocks", journalStockService.findAll());
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("typesTransactionStock", typeTransactionStockService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        JournalStockDTO edit = (editId != null) ? journalStockService.findById(editId) : null;
        model.addAttribute("editJournalStock", edit);
        return "produit/journal-stocks";
    }

    @PostMapping("/journal-stocks/save")
    public String saveJournalStock(@ModelAttribute JournalStockDTO dto) {
        if (dto.getIdProduit() != null) {
            journalStockService.save(dto);
        }
        return "redirect:/produits/journal-stocks";
    }

    @PostMapping("/journal-stocks/delete/{id}")
    public String deleteJournalStock(@PathVariable Integer id) {
        journalStockService.delete(id);
        return "redirect:/produits/journal-stocks";
    }

    // --- Types de transaction stock ---

    @GetMapping("/types-transaction-stock")
    public String typesTransactionStock(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesTransactionStock", typeTransactionStockService.findAll());
        TypeTransactionStockDTO edit = (editId != null) ? typeTransactionStockService.findById(editId) : null;
        model.addAttribute("editTypeTransactionStock", edit);
        return "produit/types-transaction-stock";
    }

    @PostMapping("/types-transaction-stock/save")
    public String saveTypeTransactionStock(@ModelAttribute TypeTransactionStockDTO dto) {
        if (dto.getId() != null) {
            typeTransactionStockService.update(dto.getId(), dto);
        } else {
            typeTransactionStockService.save(dto);
        }
        return "redirect:/produits/types-transaction-stock";
    }

    @PostMapping("/types-transaction-stock/delete/{id}")
    public String deleteTypeTransactionStock(@PathVariable Integer id) {
        typeTransactionStockService.delete(id);
        return "redirect:/produits/types-transaction-stock";
    }
}