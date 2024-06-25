package com.binary_dot.ehr_backend.api.nose_infection_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoseInfectionTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public NoseInfectionTypeDto mapToDto(NoseInfectionType noseInfectionType) {
        return modelMapper.map(noseInfectionType, NoseInfectionTypeDto.class);
    }

    public NoseInfectionType mapToEntity(NoseInfectionTypeDto noseInfectionTypeDto) {
        return modelMapper.map(noseInfectionTypeDto, NoseInfectionType.class);
    }
}
