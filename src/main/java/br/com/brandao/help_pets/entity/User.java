package br.com.brandao.help_pets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String adress;
    private String contact;
    private String document;
}
