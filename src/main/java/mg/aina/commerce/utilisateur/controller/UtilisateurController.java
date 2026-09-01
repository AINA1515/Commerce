package mg.aina.commerce.utilisateur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mg.aina.commerce.utilisateur.dto.UtilisateurDTO;
import mg.aina.commerce.utilisateur.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<UtilisateurDTO> findAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> findById(@PathVariable("id") Integer id) {
        UtilisateurDTO dto = utilisateurService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UtilisateurDTO create(@RequestBody UtilisateurDTO dto) {
        return utilisateurService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> update(@PathVariable("id") Integer id, @RequestBody UtilisateurDTO dto) {
        UtilisateurDTO updated = utilisateurService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        utilisateurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}