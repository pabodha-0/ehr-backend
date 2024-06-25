package com.binary_dot.ehr_backend.api.ecg_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ECGTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ECGTypeDto mapToDto(ECGType ecgType) {
        return modelMapper.map(ecgType, ECGTypeDto.class);
    }

    public ECGType mapToEntity(ECGTypeDto ecgTypeDto) {
        return modelMapper.map(ecgTypeDto, ECGType.class);
    }
}
