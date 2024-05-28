package br.com.brandao.help_pets.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refuges")
public class Refuge {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private  String name;

    private String adress;

    private String contact;

    private boolean status;

    @CreatedDate
    private LocalDateTime createdAt;
}
