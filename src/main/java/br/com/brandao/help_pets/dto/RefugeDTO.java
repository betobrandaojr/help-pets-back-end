package br.com.brandao.help_pets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefugeDTO {

    @NotNull(message = "Name is mandatory")
    @NotEmpty(message = "Name is mandatory")
    private  String name;

    @NotNull(message = "Adress is mandatory")
    @NotEmpty(message = "Adress is mandatory")
    private String adress;

    @NotNull(message = "Contact is mandatory")
    @NotEmpty(message = "Contact is mandatory")
    private String contact;

    @NotNull(message = "Status is mandatory")
    private boolean status;
}
