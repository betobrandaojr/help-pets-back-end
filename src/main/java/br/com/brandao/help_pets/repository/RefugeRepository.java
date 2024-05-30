package br.com.brandao.help_pets.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brandao.help_pets.module.Refuge;

@Repository
public interface RefugeRepository extends JpaRepository<Refuge, UUID> {
    Optional<Refuge> findByName(String name);
}
