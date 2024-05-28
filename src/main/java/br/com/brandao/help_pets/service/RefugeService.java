package br.com.brandao.help_pets.service;

import br.com.brandao.help_pets.dto.RefugeDTO;
import br.com.brandao.help_pets.exceptions.RefugeAlreadyExistsException;
import br.com.brandao.help_pets.exceptions.RefugeNotFoundException;
import br.com.brandao.help_pets.module.Refuge;
import br.com.brandao.help_pets.repository.RefugeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RefugeService {

    @Autowired
    private RefugeRepository refugeRepository;

    public Page<RefugeDTO> getAll(Integer pageNumber, Integer size){
        Pageable pageable = Optional.ofNullable(pageNumber)
                .flatMap(pn-> Optional.ofNullable(size)
                        .map(sz -> PageRequest.of(pn,sz)))
                .orElse(null);
        if(pageable == null) {
            List<Refuge> refuges = this.refugeRepository.findAll();
            List<RefugeDTO> refugeDTOs = refuges.stream().map(this::convertToDto).collect(Collectors.toList());
            return new PageImpl<>(refugeDTOs);
        }else{
            Page<Refuge> page = this.refugeRepository.findAll(pageable);
            return page.map(this::convertToDto);
        }
    }
    public Refuge findById(UUID id){
        return this.refugeRepository.findById(id)
                .orElseThrow(()-> new RefugeNotFoundException("Este abrigo não existe"));
    }

    public Refuge save(RefugeDTO refugeDTO){
        if(this.refugeRepository.findByName(refugeDTO.getName()).isPresent()){
            throw  new RefugeAlreadyExistsException("Abrigo já cadastrado com este nome");
        }

        Refuge refuge = new Refuge();
        refuge.setName(refugeDTO.getName());
        refuge.setContact(refuge.getContact());
        refuge.setAdress(refuge.getAdress());
        refuge.setStatus(refuge.isStatus());
        return this.refugeRepository.save(refuge);
    }

    public Refuge update(UUID id, RefugeDTO refugeDTO){
        Refuge existingRefuge = findById(id);
        existingRefuge.setName(refugeDTO.getName());
        existingRefuge.setContact(refugeDTO.getContact());
        existingRefuge.setAdress(refugeDTO.getAdress());
        existingRefuge.setStatus(refugeDTO.isStatus());
        return this.refugeRepository.save(existingRefuge);
    }

    public void deleteById(UUID id ){
        findById(id);
        this.refugeRepository.deleteById(id);
    }

    private RefugeDTO convertToDto(Refuge refuge){
        return new RefugeDTO(
                refuge.getName(),
                refuge.getAdress(),
                refuge.getContact(),
                refuge.isStatus());//Não sei se usar o isStatus da certo
    }
}
