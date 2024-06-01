package br.com.brandao.help_pets.repository;

import br.com.brandao.help_pets.module.Stell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StellRepository extends JpaRepository<Stell, UUID> {
}
