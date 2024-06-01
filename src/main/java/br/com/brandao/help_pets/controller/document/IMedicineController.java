package br.com.brandao.help_pets.controller.document;


import br.com.brandao.help_pets.dto.MedicineDTO;
import br.com.brandao.help_pets.module.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

public interface IMedicineController {
    @GetMapping
    Page<MedicineDTO> getAllMedicines(@RequestParam(required = false) Integer page,
                                    @RequestParam(required = false) Integer size);

    @GetMapping("/{id}")
    ResponseEntity<Medicine> getMedicineById(@PathVariable UUID id);

    @PostMapping
    ResponseEntity<Medicine> createMedicine(@Valid @RequestBody MedicineDTO medicineDTO);

    @PutMapping("/{id}")
    ResponseEntity<Medicine> updateMedicine(@PathVariable UUID id, @Valid @RequestBody MedicineDTO medicineDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleMedicine(@PathVariable UUID id);
}
