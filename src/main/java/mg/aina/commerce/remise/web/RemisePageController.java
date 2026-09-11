package mg.aina.commerce.remise.web;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;

import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.remise.dto.HistoriqueRemiseDTO;
import mg.aina.commerce.remise.dto.RemiseDTO;
import mg.aina.commerce.remise.entity.TypeChangementRemise;
import mg.aina.commerce.remise.service.HistoriqueRemiseService;
import mg.aina.commerce.remise.service.RemiseService;
import mg.aina.commerce.remise.service.TypeChangementRemiseService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
 */
@Controller
@RequestMapping("/remises")
public class RemisePageController {

    private final RemiseService remiseService;
    private final HistoriqueRemiseService historiqueRemiseService;
    private final TypeChangementRemiseService typeChangementRemiseService;
    private final UtilisateurService utilisateurService;
    private final ProduitService produitService;

    public RemisePageController(RemiseService remiseService,
                                HistoriqueRemiseService historiqueRemiseService,
                                TypeChangementRemiseService typeChangementRemiseService,
                                UtilisateurService utilisateurService,
                                ProduitService produitService) {
        this.remiseService = remiseService;
        this.historiqueRemiseService = historiqueRemiseService;
        this.typeChangementRemiseService = typeChangementRemiseService;
        this.utilisateurService = utilisateurService;
        this.produitService = produitService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
    }

    // --- Remises ---

    @GetMapping
    public String remises(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("remises", remiseService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("produits", produitService.findAll());
        RemiseDTO edit = (editId != null) ? remiseService.findById(editId) : null;
        model.addAttribute("editRemise", edit);
        return "remise/remises";
    }

    @PostMapping("/save")
    public String saveRemise(@ModelAttribute RemiseDTO dto) {
        if (dto.getId() != null) {
            remiseService.update(dto.getId(), dto);
        } else {
            remiseService.save(dto);
        }
        return "redirect:/remises";
    }

    @PostMapping("/delete/{id}")
    public String deleteRemise(@PathVariable Integer id) {
        remiseService.delete(id);
        return "redirect:/remises";
    }

    // --- Historique des remises ---

    @GetMapping("/historique")
    public String historique(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("historiques", historiqueRemiseService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("typesChangement", typeChangementRemiseService.findAll());
        HistoriqueRemiseDTO edit = (editId != null) ? historiqueRemiseService.findById(editId) : null;
        model.addAttribute("editHistorique", edit);
        return "remise/historique";
    }

    @PostMapping("/historique/save")
    public String saveHistorique(@ModelAttribute HistoriqueRemiseDTO dto) {
        if (dto.getId() != null) {
            historiqueRemiseService.update(dto.getId(), dto);
        } else {
            historiqueRemiseService.save(dto);
        }
        return "redirect:/remises/historique";
    }

    @PostMapping("/historique/delete/{id}")
    public String deleteHistorique(@PathVariable Integer id) {
        historiqueRemiseService.delete(id);
        return "redirect:/remises/historique";
    }

    // --- Types de changement de remise ---

    @GetMapping("/types-changement")
    public String typesChangement(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesChangement", typeChangementRemiseService.findAll());
        TypeChangementRemise edit = (editId != null) ? typeChangementRemiseService.findById(editId) : null;
        model.addAttribute("editTypeChangement", edit);
        return "remise/types-changement";
    }

    @PostMapping("/types-changement/save")
    public String saveTypeChangement(@ModelAttribute TypeChangementRemise entity) {
        if (entity.getId() != null) {
            typeChangementRemiseService.update(entity.getId(), entity);
        } else {
            typeChangementRemiseService.save(entity);
        }
        return "redirect:/remises/types-changement";
    }

    @PostMapping("/types-changement/delete/{id}")
    public String deleteTypeChangement(@PathVariable Integer id) {
        typeChangementRemiseService.delete(id);
        return "redirect:/remises/types-changement";
    }

    /**
     * Editeur de propriete permettant de lier une valeur de champ date/formulaire
     * (ex: "2026-01-15") vers un {@link java.sql.Timestamp}.
     */
    private static class TimestampEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text == null || text.isBlank()) {
                setValue(null);
                return;
            }
            String s = text.trim().replace('T', ' ');
            if (s.length() == 10) {
                s = s + " 00:00:00";
            } else if (s.length() == 16) {
                s = s + ":00";
            }
            setValue(Timestamp.valueOf(s));
        }

        @Override
        public String getAsText() {
            Timestamp value = (Timestamp) getValue();
            return value != null ? value.toString() : "";
        }
    }
}
