package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbdomenInfectionTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public AbdomenInfectionTypeDto mapToDto(AbdomenInfectionType abdomenInfectionType) {
        return modelMapper.map(abdomenInfectionType, AbdomenInfectionTypeDto.class);
    }

    public AbdomenInfectionType mapToEntity(AbdomenInfectionTypeDto abdomenInfectionTypeDto) {
        return modelMapper.map(abdomenInfectionTypeDto, AbdomenInfectionType.class);
    }

}
