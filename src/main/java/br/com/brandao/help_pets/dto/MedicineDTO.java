package br.com.brandao.help_pets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {

    @NotNull(message = "Name is mandatory")
    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Description is mandatory")
    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Dosage is mandatory")
    @NotEmpty(message = "Dosage is mandatory")
    private String dosage;

    @NotNull(message = "Amount is mandatory")
    private String amount = "0";

    @NotNull(message = "Status is mandatory")
    private boolean status = true;
}
