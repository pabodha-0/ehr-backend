package com.binary_dot.ehr_backend.api.lungs_infection_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LungsInfectionTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public LungsInfectionTypeDto mapToDto(LungsInfectionType lungsInfectionType) {
        return modelMapper.map(lungsInfectionType, LungsInfectionTypeDto.class);
    }

    public LungsInfectionType mapToEntity(LungsInfectionTypeDto lungsInfectionTypeDto) {
        return modelMapper.map(lungsInfectionTypeDto, LungsInfectionType.class);
    }
}
