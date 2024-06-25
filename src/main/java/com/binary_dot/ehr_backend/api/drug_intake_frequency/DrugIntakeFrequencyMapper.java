package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugIntakeFrequencyMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DrugIntakeFrequencyDto mapToDto(DrugIntakeFrequency drugIntakeFrequency) {
        return modelMapper.map(drugIntakeFrequency, DrugIntakeFrequencyDto.class);
    }

    public DrugIntakeFrequency mapToEntity(DrugIntakeFrequencyDto drugIntakeFrequencyDto) {
        return modelMapper.map(drugIntakeFrequencyDto, DrugIntakeFrequency.class);
    }
}
