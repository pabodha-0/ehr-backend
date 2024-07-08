package com.binary_dot.ehr_backend.api.symptom;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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

    @Override
    public SymptomDto findById(int id) throws NotFoundException {
        Symptom symptom = symptomRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Symptom not found by Id: " + id)
        );
        return symptomMapper.mapToDto(symptom);
    }

    @Override
    public List<SymptomDto> findAll() {
        List<Symptom> symptoms = symptomRepository.findAll();
        return symptoms.stream().map(symptom -> symptomMapper.mapToDto(symptom)).toList();
    }
}
