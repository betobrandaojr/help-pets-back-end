package br.com.brandao.help_pets.mapper;

import br.com.brandao.help_pets.dto.StellDTO;
import br.com.brandao.help_pets.module.Stell;

public class StellMapper {
    public static StellDTO toDTO(Stell stell) {
        if (stell == null) {
            return null;
        }
        return new StellDTO(
            stell.getId(),
            stell.getNumber(),
            stell.getRefugId().getId(),
            stell.isStatus(),
            stell.getCreateDate(),
            stell.getUpdateDate()
        );
    }

    public static Stell toEntity(StellDTO stellDTO) {
        if (stellDTO == null) {
            return null;
        }
        Stell stell = new Stell();
        stell.setId(stellDTO.getId());
        stell.setNumber(stellDTO.getNumber());
        stell.setStatus(stellDTO.isStatus());
        stell.setCreateDate(stellDTO.getCreateDate());
        stell.setUpdateDate(stellDTO.getUpdateDate());
        return stell;
    }
}
