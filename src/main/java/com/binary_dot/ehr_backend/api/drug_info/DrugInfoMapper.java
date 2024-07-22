package com.binary_dot.ehr_backend.api.drug_info;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugInfoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DrugInfoDto mapToDto(DrugInfo drugInfo) {
        return modelMapper.map(drugInfo, DrugInfoDto.class);
    }

    public DrugInfo mapToEntity(DrugInfoDto drugInfoDto) {
        return modelMapper.map(drugInfoDto, DrugInfo.class);
    }
}
