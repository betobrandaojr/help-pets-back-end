package br.com.brandao.help_pets.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brandao.help_pets.dto.StellDTO;
import br.com.brandao.help_pets.mapper.StellMapper;
import br.com.brandao.help_pets.module.Refuge;
import br.com.brandao.help_pets.module.Stell;
import br.com.brandao.help_pets.repository.RefugeRepository;
import br.com.brandao.help_pets.repository.StellRepository;

@Service
public class StellService {

    @Autowired
    private StellRepository stellRepository;

    @Autowired
    private RefugeRepository refugeRepository;

    @Transactional
    public StellDTO save(StellDTO stellDTO) {
        Stell stell = StellMapper.toEntity(stellDTO);
        UUID refugeId = stellDTO.getRefugId();
        Refuge refuge = refugeRepository.findById(refugeId)
                                        .orElseThrow(() -> new RuntimeException("Refuge não encontrado"));
        stell.setRefugId(refuge);
        stell = stellRepository.save(stell);
        return StellMapper.toDTO(stell);
    }

    @Transactional
    public StellDTO update(UUID id, StellDTO stellDTO) {
        Stell existingStell = stellRepository.findById(id)
                                             .orElseThrow(() -> new RuntimeException("Stell não encontrado"));

        existingStell.setNumber(stellDTO.getNumber());
        existingStell.setStatus(stellDTO.isStatus());

        UUID refugeId = stellDTO.getRefugId();
        Refuge refuge = refugeRepository.findById(refugeId)
                                        .orElseThrow(() -> new RuntimeException("Refuge não encontrado"));
        existingStell.setRefugId(refuge);

        existingStell = stellRepository.save(existingStell);
        return StellMapper.toDTO(existingStell);
    }

    public StellDTO findById(UUID id) {
        Stell stell = stellRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Stell não encontrado"));
        return StellMapper.toDTO(stell);
    }

    public List<StellDTO> findAll() {
        List<Stell> stells = stellRepository.findAll();
        return stells.stream().map(StellMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(UUID id) {
        if (!stellRepository.existsById(id)) {
            throw new RuntimeException("Stell não encontrado");
        }
        stellRepository.deleteById(id);
    }
}
