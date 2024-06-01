package br.com.brandao.help_pets.controller;

import br.com.brandao.help_pets.controller.document.IRefugeController;
import br.com.brandao.help_pets.dto.RefugeDTO;
import br.com.brandao.help_pets.module.Refuge;
import br.com.brandao.help_pets.service.RefugeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/refuges")
public class RefugeController implements IRefugeController {
    @Autowired
    private RefugeService refugeService;

    @Override
    public Page<RefugeDTO> getAllRefuges(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return this.refugeService.getAll(page, size);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Refuge> getRefugeById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.refugeService.findById(id));
    }

    @Override
    public ResponseEntity<Refuge> createRefuge(@Valid @RequestBody RefugeDTO refugeDTO) {
        return ResponseEntity.ok(this.refugeService.save(refugeDTO));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Refuge> updateRefuge(@PathVariable UUID id, @Valid @RequestBody RefugeDTO refugeDTO) {
        return ResponseEntity.ok(this.refugeService.update(id,refugeDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleRefuge(@PathVariable UUID id) {
        this.refugeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
