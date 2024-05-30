package br.com.brandao.help_pets.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StellDTO {
    private UUID id;
    private Long number;
    private UUID refugId;
    private boolean status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
