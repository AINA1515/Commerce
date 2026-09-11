package mg.aina.commerce.commande.controller;

import mg.aina.commerce.commande.dto.PayementDTO;
import mg.aina.commerce.commande.service.LigneCommandeService;
import mg.aina.commerce.commande.service.PayementService;
import mg.aina.commerce.commande.service.TypePayementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page "Paiements" (rendu cote serveur Thymeleaf).
 */
@Controller
@RequestMapping("/commandes/payements")
public class PayementPageController {

    private final PayementService payementService;
    private final LigneCommandeService ligneCommandeService;
    private final TypePayementService typePayementService;

    public PayementPageController(PayementService payementService,
                                  LigneCommandeService ligneCommandeService,
                                  TypePayementService typePayementService) {
        this.payementService = payementService;
        this.ligneCommandeService = ligneCommandeService;
        this.typePayementService = typePayementService;
    }

    @GetMapping
    public String payements(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("payements", payementService.findAll());
        model.addAttribute("lignes", ligneCommandeService.findAll());
        model.addAttribute("typesPayement", typePayementService.findAll());
        model.addAttribute("editPayement", (editId != null) ? payementService.findById(editId) : null);
        return "commande/payements";
    }

    @PostMapping("/save")
    public String savePayement(@ModelAttribute PayementDTO dto) {
        if (dto.getId() != null) {
            payementService.update(dto.getId(), dto);
        } else {
            payementService.save(dto);
        }
        return "redirect:/commandes/payements";
    }

    @PostMapping("/delete/{id}")
    public String deletePayement(@PathVariable Integer id) {
        payementService.delete(id);
        return "redirect:/commandes/payements";
    }
}