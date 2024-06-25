package com.binary_dot.ehr_backend.api.symptom;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SymptomMapper {
    @Autowired
    private ModelMapper modelMapper;

    public SymptomDto mapToDto(Symptom symptom) {
        return modelMapper.map(symptom, SymptomDto.class);
    }

    public Symptom mapToEntity(SymptomDto symptomDto) {
        return modelMapper.map(symptomDto, Symptom.class);
    }
}
