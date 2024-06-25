package com.binary_dot.ehr_backend.api.drug_allergy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugAllergyMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DrugAllergyDto mapToDto(DrugAllergy drugAllergy) {
        return modelMapper.map(drugAllergy, DrugAllergyDto.class);
    }
    public DrugAllergy mapToEntity(DrugAllergyDto drugAllergyDto) {
        return modelMapper.map(drugAllergyDto, DrugAllergy.class);
    }
}
