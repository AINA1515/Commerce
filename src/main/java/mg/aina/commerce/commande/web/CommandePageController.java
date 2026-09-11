package mg.aina.commerce.commande.web;

import mg.aina.commerce.client.service.ClientService;
import mg.aina.commerce.commande.dto.CommandeDTO;
import mg.aina.commerce.commande.dto.JournalCommandeDTO;
import mg.aina.commerce.commande.dto.JournalCommandeFilleDTO;
import mg.aina.commerce.commande.dto.LigneCommandeDTO;
import mg.aina.commerce.commande.dto.PayementDTO;
import mg.aina.commerce.commande.entity.StatusCommande;
import mg.aina.commerce.commande.entity.StatusLigneCommande;
import mg.aina.commerce.commande.entity.TypePayement;
import mg.aina.commerce.commande.entity.TypeTransactionCommande;
import mg.aina.commerce.commande.service.CommandeService;
import mg.aina.commerce.commande.service.JournalCommandeFilleService;
import mg.aina.commerce.commande.service.JournalCommandeService;
import mg.aina.commerce.commande.service.LigneCommandeService;
import mg.aina.commerce.commande.service.PayementService;
import mg.aina.commerce.commande.service.StatusCommandeService;
import mg.aina.commerce.commande.service.StatusLigneCommandeService;
import mg.aina.commerce.commande.service.TypePayementService;
import mg.aina.commerce.commande.service.TypeTransactionCommandeService;
import mg.aina.commerce.produit.service.ProduitService;
import mg.aina.commerce.utilisateur.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques.
 */
@Controller
@RequestMapping("/commandes")
public class CommandePageController {

    private final CommandeService commandeService;
    private final LigneCommandeService ligneCommandeService;
    private final PayementService payementService;
    private final JournalCommandeService journalCommandeService;
    private final JournalCommandeFilleService journalCommandeFilleService;
    private final StatusCommandeService statusCommandeService;
    private final StatusLigneCommandeService statusLigneCommandeService;
    private final TypePayementService typePayementService;
    private final TypeTransactionCommandeService typeTransactionCommandeService;
    private final ClientService clientService;
    private final ProduitService produitService;
    private final UtilisateurService utilisateurService;

    public CommandePageController(CommandeService commandeService,
                                  LigneCommandeService ligneCommandeService,
                                  PayementService payementService,
                                  JournalCommandeService journalCommandeService,
                                  JournalCommandeFilleService journalCommandeFilleService,
                                  StatusCommandeService statusCommandeService,
                                  StatusLigneCommandeService statusLigneCommandeService,
                                  TypePayementService typePayementService,
                                  TypeTransactionCommandeService typeTransactionCommandeService,
                                  ClientService clientService,
                                  ProduitService produitService,
                                  UtilisateurService utilisateurService) {
        this.commandeService = commandeService;
        this.ligneCommandeService = ligneCommandeService;
        this.payementService = payementService;
        this.journalCommandeService = journalCommandeService;
        this.journalCommandeFilleService = journalCommandeFilleService;
        this.statusCommandeService = statusCommandeService;
        this.statusLigneCommandeService = statusLigneCommandeService;
        this.typePayementService = typePayementService;
        this.typeTransactionCommandeService = typeTransactionCommandeService;
        this.clientService = clientService;
        this.produitService = produitService;
        this.utilisateurService = utilisateurService;
    }

    // --- Commandes ---

    @GetMapping
    public String commandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("commandes", commandeService.findAll());
        model.addAttribute("typesTransaction", typeTransactionCommandeService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("editCommande", (editId != null) ? commandeService.findById(editId) : null);
        return "commande/commandes";
    }

    @PostMapping("/save")
    public String saveCommande(@ModelAttribute CommandeDTO dto) {
        if (dto.getId() != null) {
            commandeService.update(dto.getId(), dto);
        } else {
            commandeService.save(dto);
        }
        return "redirect:/commandes";
    }

    @PostMapping("/delete/{id}")
    public String deleteCommande(@PathVariable Integer id) {
        commandeService.delete(id);
        return "redirect:/commandes";
    }

    // --- Lignes de commande ---

    @GetMapping("/lignes")
    public String lignes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("lignes", ligneCommandeService.findAll());
        model.addAttribute("commandes", commandeService.findAll());
        model.addAttribute("produits", produitService.findAll());
        model.addAttribute("statusLigne", statusLigneCommandeService.findAll());
        model.addAttribute("editLigne", (editId != null) ? ligneCommandeService.findById(editId) : null);
        return "commande/lignes";
    }

    @PostMapping("/lignes/save")
    public String saveLigne(@ModelAttribute LigneCommandeDTO dto) {
        if (dto.getId() != null) {
            ligneCommandeService.update(dto.getId(), dto);
        } else {
            ligneCommandeService.save(dto);
        }
        return "redirect:/commandes/lignes";
    }

    @PostMapping("/lignes/delete/{id}")
    public String deleteLigne(@PathVariable Integer id) {
        ligneCommandeService.delete(id);
        return "redirect:/commandes/lignes";
    }

    // --- Journal des commandes ---

    @GetMapping("/journal")
    public String journalCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("journals", journalCommandeService.findAll());
        model.addAttribute("commandes", commandeService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("editJournal", (editId != null) ? journalCommandeService.findById(editId) : null);
        return "commande/journal-commandes";
    }

    @PostMapping("/journal/save")
    public String saveJournalCommande(@ModelAttribute JournalCommandeDTO dto) {
        if (dto.getId() != null) {
            journalCommandeService.update(dto.getId(), dto);
        } else {
            journalCommandeService.save(dto);
        }
        return "redirect:/commandes/journal";
    }

    @PostMapping("/journal/delete/{id}")
    public String deleteJournalCommande(@PathVariable Integer id) {
        journalCommandeService.delete(id);
        return "redirect:/commandes/journal";
    }
    // --- Journal des commandes filles ---

    @GetMapping("/journal-filles")
    public String journalFilles(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("journalFilles", journalCommandeFilleService.findAll());
        model.addAttribute("lignes", ligneCommandeService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("editJournalFille", (editId != null) ? journalCommandeFilleService.findById(editId) : null);
        return "commande/journal-commande-filles";
    }

    @PostMapping("/journal-filles/save")
    public String saveJournalFille(@ModelAttribute JournalCommandeFilleDTO dto) {
        if (dto.getId() != null) {
            journalCommandeFilleService.update(dto.getId(), dto);
        } else {
            journalCommandeFilleService.save(dto);
        }
        return "redirect:/commandes/journal-filles";
    }

    @PostMapping("/journal-filles/delete/{id}")
    public String deleteJournalFille(@PathVariable Integer id) {
        journalCommandeFilleService.delete(id);
        return "redirect:/commandes/journal-filles";
    }
    // --- Statuts de commande ---

    @GetMapping("/status")
    public String statusCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("statusCommandes", statusCommandeService.findAll());
        model.addAttribute("editStatusCommande", (editId != null) ? statusCommandeService.findById(editId) : null);
        return "commande/status-commandes";
    }

    @PostMapping("/status/save")
    public String saveStatusCommande(@ModelAttribute StatusCommande entity) {
        if (entity.getId() != null) {
            statusCommandeService.update(entity.getId(), entity);
        } else {
            statusCommandeService.save(entity);
        }
        return "redirect:/commandes/status";
    }

    @PostMapping("/status/delete/{id}")
    public String deleteStatusCommande(@PathVariable Integer id) {
        statusCommandeService.delete(id);
        return "redirect:/commandes/status";
    }

    // --- Statuts de ligne de commande ---

    @GetMapping("/status-lignes")
    public String statusLigneCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("statusLignes", statusLigneCommandeService.findAll());
        model.addAttribute("editStatusLigne", (editId != null) ? statusLigneCommandeService.findById(editId) : null);
        return "commande/status-ligne-commandes";
    }

    @PostMapping("/status-lignes/save")
    public String saveStatusLigneCommande(@ModelAttribute StatusLigneCommande entity) {
        if (entity.getId() != null) {
            statusLigneCommandeService.update(entity.getId(), entity);
        } else {
            statusLigneCommandeService.save(entity);
        }
        return "redirect:/commandes/status-lignes";
    }

    @PostMapping("/status-lignes/delete/{id}")
    public String deleteStatusLigneCommande(@PathVariable Integer id) {
        statusLigneCommandeService.delete(id);
        return "redirect:/commandes/status-lignes";
    }

    // --- Types de paiement ---

    @GetMapping("/types-payement")
    public String typePayements(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesPayement", typePayementService.findAll());
        model.addAttribute("editTypePayement", (editId != null) ? typePayementService.findById(editId) : null);
        return "commande/type-payements";
    }

    @PostMapping("/types-payement/save")
    public String saveTypePayement(@ModelAttribute TypePayement entity) {
        if (entity.getId() != null) {
            typePayementService.update(entity.getId(), entity);
        } else {
            typePayementService.save(entity);
        }
        return "redirect:/commandes/types-payement";
    }

    @PostMapping("/types-payement/delete/{id}")
    public String deleteTypePayement(@PathVariable Integer id) {
        typePayementService.delete(id);
        return "redirect:/commandes/types-payement";
    }

    // --- Types de transaction commande ---

    @GetMapping("/types-transaction")
    public String typeTransactionCommandes(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("typesTransaction", typeTransactionCommandeService.findAll());
        model.addAttribute("editTypeTransaction", (editId != null) ? typeTransactionCommandeService.findById(editId) : null);
        return "commande/type-transaction-commandes";
    }

    @PostMapping("/types-transaction/save")
    public String saveTypeTransactionCommande(@ModelAttribute TypeTransactionCommande entity) {
        if (entity.getId() != null) {
            typeTransactionCommandeService.update(entity.getId(), entity);
        } else {
            typeTransactionCommandeService.save(entity);
        }
        return "redirect:/commandes/types-transaction";
    }

    @PostMapping("/types-transaction/delete/{id}")
    public String deleteTypeTransactionCommande(@PathVariable Integer id) {
        typeTransactionCommandeService.delete(id);
        return "redirect:/commandes/types-transaction";
    }

    // --- Paiements ---

    @GetMapping("/payements")
    public String payements(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("payements", payementService.findAll());
        model.addAttribute("lignes", ligneCommandeService.findAll());
        model.addAttribute("typesPayement", typePayementService.findAll());
        model.addAttribute("editPayement", (editId != null) ? payementService.findById(editId) : null);
        return "commande/payements";
    }

    @PostMapping("/payements/save")
    public String savePayement(@ModelAttribute PayementDTO dto) {
        if (dto.getId() != null) {
            payementService.update(dto.getId(), dto);
        } else {
            payementService.save(dto);
        }
        return "redirect:/commandes/payements";
    }

    @PostMapping("/payements/delete/{id}")
    public String deletePayement(@PathVariable Integer id) {
        payementService.delete(id);
        return "redirect:/commandes/payements";
    }
}
