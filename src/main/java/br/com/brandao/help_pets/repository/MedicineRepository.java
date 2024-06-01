package br.com.brandao.help_pets.repository;

import br.com.brandao.help_pets.module.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MedicineRepository extends JpaRepository<Medicine, UUID> {
    Optional<Medicine> findByName(String name);
}
