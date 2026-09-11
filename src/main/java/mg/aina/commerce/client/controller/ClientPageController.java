package mg.aina.commerce.client.controller;

import mg.aina.commerce.client.dto.ClientDTO;
import mg.aina.commerce.client.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur de page (rendu cote serveur Thymeleaf). Le CRUD est gere ici via
 * des formulaires POST classiques, qui deledent vers ClientService.
 */
@Controller
@RequestMapping("/clients")
public class ClientPageController {

    private final ClientService clientService;

    public ClientPageController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String clients(@RequestParam(value = "edit", required = false) Integer editId, Model model) {
        model.addAttribute("clients", clientService.findAll());
        ClientDTO edit = (editId != null) ? clientService.findById(editId) : null;
        model.addAttribute("editClient", edit);
        return "client/clients";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ClientDTO dto) {
        if (dto.getId() != null) {
            clientService.update(dto.getId(), dto);
        } else {
            clientService.save(dto);
        }
        return "redirect:/clients";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}