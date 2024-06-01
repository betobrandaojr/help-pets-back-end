package br.com.brandao.help_pets.controller;


import br.com.brandao.help_pets.controller.document.IMedicineController;
import br.com.brandao.help_pets.dto.MedicineDTO;
import br.com.brandao.help_pets.module.Medicine;
import br.com.brandao.help_pets.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/medicines")
public class MedicineController implements IMedicineController {

    @Autowired
    private MedicineService medicineService;

    @Override
    public Page<MedicineDTO> getAllMedicines(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return this.medicineService.getAll(page, size);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.medicineService.findById(id));
    }

    @Override
    public ResponseEntity<Medicine> createMedicine(@Valid @RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok(this.medicineService.save(medicineDTO));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable UUID id, @Valid @RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok(this.medicineService.update(id,medicineDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleMedicine(@PathVariable UUID id) {
        this.medicineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
