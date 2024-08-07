package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugIntakeFrequencyImpl implements DrugIntakeFrequencyService{
    @Autowired
    DrugIntakeFrequencyRepository drugIntakeFrequencyRepository;

    @Autowired
    DrugIntakeFrequencyMapper drugIntakeFrequencyMapper;

    @Override
    public DrugIntakeFrequencyDto createDrugIntakeFrequency(DrugIntakeFrequencyDto drugIntakeFrequencyDto) {
        if(drugIntakeFrequencyDto == null) {
            return null;
        }
        List<DrugIntakeFrequency> existingDrugIntakeFrequency = drugIntakeFrequencyRepository.findByName(drugIntakeFrequencyDto.getName());
        if(existingDrugIntakeFrequency.isEmpty()) {
            DrugIntakeFrequency drugIntakeFrequency = drugIntakeFrequencyRepository.save(drugIntakeFrequencyMapper.mapToEntity(drugIntakeFrequencyDto));
            return drugIntakeFrequencyMapper.mapToDto(drugIntakeFrequency);
        }

        return drugIntakeFrequencyMapper.mapToDto(existingDrugIntakeFrequency.getFirst());
    }

    @Override
    public DrugIntakeFrequencyDto findById(int id) throws NotFoundException {
        Optional<DrugIntakeFrequency> drugIntakeFrequency = drugIntakeFrequencyRepository.findById(id);
        if(drugIntakeFrequency.isPresent()) {
            return drugIntakeFrequencyMapper.mapToDto(drugIntakeFrequency.get());
        }

        throw new NotFoundException("Drug Intake Frequency not found by id: " + id);
    }

    @Override
    public List<DrugIntakeFrequencyDto> findAll() {
        List<DrugIntakeFrequency> drugIntakeFrequencyList = drugIntakeFrequencyRepository.findAll();
        return drugIntakeFrequencyList.stream().map(dif -> drugIntakeFrequencyMapper.mapToDto(dif)).toList();
    }
}
