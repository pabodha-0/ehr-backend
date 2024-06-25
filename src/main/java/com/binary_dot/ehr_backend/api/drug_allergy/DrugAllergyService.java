package com.binary_dot.ehr_backend.api.drug_allergy;

import java.util.List;

public interface DrugAllergyService {
    DrugAllergyDto addDrugAllergy(DrugAllergyDto drugAllergyDto);
    List<DrugAllergyDto> addDrugAllergies(List<DrugAllergyDto> drugAllergyDtoList);
}
