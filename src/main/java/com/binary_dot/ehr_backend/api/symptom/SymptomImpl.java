package com.binary_dot.ehr_backend.api.symptom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomImpl implements SymptomService{
    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    SymptomMapper symptomMapper;

    @Override
    public SymptomDto addSymptom(SymptomDto symptomDto) {
        List<Symptom> existingSymptom = symptomRepository.findByName(symptomDto.getName());
        if(existingSymptom.isEmpty()) {
            Symptom symptom = symptomRepository.save(symptomMapper.mapToEntity(symptomDto));
            return symptomMapper.mapToDto(symptom);
        }

        return symptomMapper.mapToDto(existingSymptom.getFirst());
    }

    @Override
    public List<SymptomDto> addSymptoms(List<SymptomDto> symptomDtoList) {
        List<SymptomDto> symptoms = new ArrayList<>();
        for (SymptomDto symptomDto : symptomDtoList) {
            symptoms.add(addSymptom(symptomDto));
        }

        return symptoms;
    }
}
