package com.binary_dot.ehr_backend.api.drug_allergy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugAllergyImpl implements DrugAllergyService{
    @Autowired
    private DrugAllergyRepository drugAllergyRepository;

    @Autowired
    private DrugAllergyMapper drugAllergyMapper;

    @Override
    public DrugAllergyDto addDrugAllergy(DrugAllergyDto drugAllergyDto) {
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
}
