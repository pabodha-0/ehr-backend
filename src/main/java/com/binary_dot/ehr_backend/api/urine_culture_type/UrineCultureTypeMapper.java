package com.binary_dot.ehr_backend.api.urine_culture_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UrineCultureTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UrineCultureTypeDto mapToDto(UrineCultureType urineCultureType) {
        return modelMapper.map(urineCultureType, UrineCultureTypeDto.class);
    }

    public UrineCultureType mapToEntity(UrineCultureTypeDto urineCultureTypeDto) {
        return modelMapper.map(urineCultureTypeDto, UrineCultureType.class);
    }
}
