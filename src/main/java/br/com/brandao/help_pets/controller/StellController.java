package br.com.brandao.help_pets.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.brandao.help_pets.dto.StellDTO;
import br.com.brandao.help_pets.service.StellService;

@RestController
@RequestMapping("/api/stells")
public class StellController {

    @Autowired
    private StellService stellService;

    @PostMapping
    public ResponseEntity<StellDTO> createStell(@RequestBody StellDTO stellDTO) {
        StellDTO createdStell = stellService.save(stellDTO);
        return ResponseEntity.ok(createdStell);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StellDTO> updateStell(@PathVariable UUID id, @RequestBody StellDTO stellDTO) {
        StellDTO updatedStell = stellService.update(id, stellDTO);
        return ResponseEntity.ok(updatedStell);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StellDTO> getStellById(@PathVariable UUID id) {
        StellDTO stell = stellService.findById(id);
        return ResponseEntity.ok(stell);
    }

    @GetMapping
    public ResponseEntity<List<StellDTO>> getAllStells() {
        List<StellDTO> stells = stellService.findAll();
        return ResponseEntity.ok(stells);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStellById(@PathVariable UUID id) {
        stellService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

