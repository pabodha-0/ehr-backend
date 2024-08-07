package com.binary_dot.ehr_backend.api.drug_allergy;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugAllergyImpl implements DrugAllergyService{
    @Autowired
    private DrugAllergyRepository drugAllergyRepository;

    @Autowired
    private DrugAllergyMapper drugAllergyMapper;

    @Override
    public DrugAllergyDto addDrugAllergy(DrugAllergyDto drugAllergyDto) {
        if(drugAllergyDto == null) {
            return null;
        }
        List<DrugAllergy> existingDrugAllergies = drugAllergyRepository.findByName(drugAllergyDto.getName());
        if (existingDrugAllergies.isEmpty()) {
            DrugAllergy drugAllergy = drugAllergyRepository.save(drugAllergyMapper.mapToEntity(drugAllergyDto));
            return drugAllergyMapper.mapToDto(drugAllergy);
        }
        return drugAllergyMapper.mapToDto(existingDrugAllergies.getFirst());
    }

    @Override
    public List<DrugAllergyDto> addDrugAllergies(List<DrugAllergyDto> drugAllergyDtoList) {
        if(drugAllergyDtoList == null || drugAllergyDtoList.isEmpty()){
            return new ArrayList<>();
        }

        List<DrugAllergyDto> drugAllergies = new ArrayList<>();
        for(DrugAllergyDto drugAllergyDto : drugAllergyDtoList) {
            drugAllergies.add(addDrugAllergy(drugAllergyDto));
        }

        return drugAllergies;
    }

    @Override
    public DrugAllergyDto findById(int id) throws NotFoundException {
        Optional<DrugAllergy> drugAllergy = drugAllergyRepository.findById(id);
        if(drugAllergy.isPresent()) {
            return drugAllergyMapper.mapToDto(drugAllergy.get());
        }

        throw new NotFoundException("Drug Allergy not found by Id: " + id);
    }

    @Override
    public List<DrugAllergyDto> findAll() {
        List<DrugAllergy> drugAllergies = drugAllergyRepository.findAll();
        return drugAllergies.stream().map(allergy -> drugAllergyMapper.mapToDto(allergy)).toList();
    }
}
