package com.binary_dot.ehr_backend.api.drug;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DrugDto mapToDto(Drug drug) {
        return modelMapper.map(drug, DrugDto.class);
    }

    public Drug mapToEntity(DrugDto drugDto) {
        return modelMapper.map(drugDto, Drug.class);
    }
}
