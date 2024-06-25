package com.binary_dot.ehr_backend.api.symptom;

import java.util.List;

public interface SymptomService {
    SymptomDto addSymptom(SymptomDto symptomDto);
    List<SymptomDto> addSymptoms(List<SymptomDto> symptomDtoList);

}
