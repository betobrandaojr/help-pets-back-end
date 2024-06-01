package br.com.brandao.help_pets.service;


import br.com.brandao.help_pets.dto.MedicineDTO;
import br.com.brandao.help_pets.module.Medicine;
import br.com.brandao.help_pets.repository.MedicineRepository;
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
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    public Page<MedicineDTO> getAll(Integer pageNumber, Integer size){
        Pageable pageable = Optional.ofNullable(pageNumber)
                .flatMap(pn-> Optional.ofNullable(size)
                        .map(sz -> PageRequest.of(pn,sz)))
                .orElse(null);
        if(pageable == null) {
            List<Medicine> medicines = this.medicineRepository.findAll();
            List<MedicineDTO> medicineDTOs = medicines.stream().map(this::convertToDto).collect(Collectors.toList());
            return new PageImpl<>(medicineDTOs);
        }else{
            Page<Medicine> page = this.medicineRepository.findAll(pageable);
            return page.map(this::convertToDto);
        }
    }
    public Medicine findById(UUID id){
        return this.medicineRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Este Medicamento não existe"));
    }

    public Medicine save(MedicineDTO medicineDTO){
        if(this.medicineRepository.findByName(medicineDTO.getName()).isPresent()){
            throw  new RuntimeException("Medicamento já cadastrado com este nome");
        }

        Medicine medicine = new Medicine();
        medicine.setName(medicineDTO.getName());
        medicine.setDescription(medicineDTO.getDescription());
        medicine.setAmount(medicineDTO.getAmount());
        medicine.setDosage(medicineDTO.getDosage());
        medicine.setStatus(medicineDTO.isStatus());

        return this.medicineRepository.save(medicine);
    }

    public Medicine update(UUID id, MedicineDTO medicineDTO){
        Medicine existingMedicine = findById(id);
        existingMedicine.setName(medicineDTO.getName());
        existingMedicine.setDescription(medicineDTO.getDescription());
        existingMedicine.setAmount(medicineDTO.getAmount());
        existingMedicine.setDosage(medicineDTO.getDosage());
        existingMedicine.setStatus(medicineDTO.isStatus());
        return this.medicineRepository.save(existingMedicine);
    }

    public void deleteById(UUID id ){
        findById(id);
        this.medicineRepository.deleteById(id);
    }

    private MedicineDTO convertToDto(Medicine medicine){
        return new MedicineDTO(
                medicine.getName(),
                medicine.getDescription(),
                medicine.getDosage(),
                medicine.getAmount(),
                medicine.isStatus()
        );

    }
}
