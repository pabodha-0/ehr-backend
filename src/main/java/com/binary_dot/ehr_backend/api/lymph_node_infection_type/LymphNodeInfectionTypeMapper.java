package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LymphNodeInfectionTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public LymphNodeInfectionTypeDto mapToDto(LymphNodeInfectionType lymphNodeInfectionType) {
        return modelMapper.map(lymphNodeInfectionType, LymphNodeInfectionTypeDto.class);
    }

    public LymphNodeInfectionType mapToEntity(LymphNodeInfectionTypeDto lymphNodeInfectionTypeDto) {
        return modelMapper.map(lymphNodeInfectionTypeDto, LymphNodeInfectionType.class);
    }
}
