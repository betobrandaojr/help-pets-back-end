package br.com.brandao.help_pets.repository;

import br.com.brandao.help_pets.module.Refuge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefugeRepository extends JpaRepository<Refuge, UUID> {
    Optional<Refuge> findByName(String name);
}
