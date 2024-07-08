package com.binary_dot.ehr_backend.api.symptom;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface SymptomService {
    SymptomDto addSymptom(SymptomDto symptomDto);
    List<SymptomDto> addSymptoms(List<SymptomDto> symptomDtoList);
    SymptomDto findById(int id) throws NotFoundException;
    List<SymptomDto> findAll();

}
