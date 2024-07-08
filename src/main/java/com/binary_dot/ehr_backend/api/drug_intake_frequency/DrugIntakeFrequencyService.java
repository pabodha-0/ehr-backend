package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface DrugIntakeFrequencyService {
    DrugIntakeFrequencyDto createDrugIntakeFrequency(DrugIntakeFrequencyDto drugIntakeFrequencyDto);
    DrugIntakeFrequencyDto findById(int id) throws NotFoundException;
    List<DrugIntakeFrequencyDto> findAll();

}
