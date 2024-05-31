package br.com.brandao.help_pets.module;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.brandao.help_pets.module.Refuge;
import jakarta.persistence.Column;

public class Medicament {

    private UUID id;

    private String name;

    private String description;

    private String dosage;

    private String amount;

    private Refuge refugeId;

    private boolean status;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
