package com.binary_dot.ehr_backend.api.ear_infection_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EarInfectionTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public EarInfectionTypeDto mapToDto(EarInfectionType earInfectionType) {
        return modelMapper.map(earInfectionType, EarInfectionTypeDto.class);
    }

    public EarInfectionType mapToEntity(EarInfectionTypeDto earInfectionTypeDto) {
        return modelMapper.map(earInfectionTypeDto, EarInfectionType.class);
    }
}
