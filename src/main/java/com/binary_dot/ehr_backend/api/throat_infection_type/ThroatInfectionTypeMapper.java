package com.binary_dot.ehr_backend.api.throat_infection_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThroatInfectionTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ThroatInfectionTypeDto mapToDto(ThroatInfectionType throatInfectionType) {
        return modelMapper.map(throatInfectionType, ThroatInfectionTypeDto.class);
    }

    public ThroatInfectionType mapToEntity(ThroatInfectionTypeDto throatInfectionTypeDto) {
        return modelMapper.map(throatInfectionTypeDto, ThroatInfectionType.class);
    }
}
