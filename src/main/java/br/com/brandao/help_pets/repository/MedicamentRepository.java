package br.com.brandao.help_pets.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brandao.help_pets.module.Medicament;

public interface MedicamentRepository  extends JpaRepository<Medicament, UUID>{
    
}
