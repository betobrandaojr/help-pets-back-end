package br.com.brandao.help_pets.controller.document;

import br.com.brandao.help_pets.dto.RefugeDTO;
import br.com.brandao.help_pets.module.Refuge;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

public interface IRefugeController {
    @GetMapping
    Page<RefugeDTO> getAllRefuges(@RequestParam(required = false) Integer page,
                                  @RequestParam(required = false) Integer size);

    @GetMapping("/{id}")
    ResponseEntity<Refuge> getRefugeById(@PathVariable UUID id);

    @PostMapping
    ResponseEntity<Refuge> createRefuge(@Valid @RequestBody RefugeDTO refugeDTO);

    @PutMapping("/{id}")
    ResponseEntity<Refuge> updateRefuge(@PathVariable UUID id, @Valid @RequestBody RefugeDTO refugeDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleRefuge(@PathVariable UUID id);
}
