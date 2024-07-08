package com.binary_dot.ehr_backend.api.drug_allergy;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface DrugAllergyService {
    DrugAllergyDto addDrugAllergy(DrugAllergyDto drugAllergyDto);
    List<DrugAllergyDto> addDrugAllergies(List<DrugAllergyDto> drugAllergyDtoList);
    DrugAllergyDto findById(int id) throws NotFoundException;
    List<DrugAllergyDto> findAll();
}
