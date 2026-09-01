package mg.aina.commerce.remise.controller;

import mg.aina.commerce.remise.dto.RemiseDTO;
import mg.aina.commerce.remise.service.RemiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remises")
public class RemiseController {
    private final RemiseService service;

    public RemiseController(RemiseService service) {
        this.service = service;
    }

    @GetMapping
    public List<RemiseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemiseDTO> findById(@PathVariable("id") Integer id) {
        RemiseDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public RemiseDTO create(@RequestBody RemiseDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemiseDTO> update(@PathVariable("id") Integer id, @RequestBody RemiseDTO dto) {
        RemiseDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
