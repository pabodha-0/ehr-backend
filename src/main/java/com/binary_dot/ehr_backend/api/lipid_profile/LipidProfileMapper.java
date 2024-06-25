package com.binary_dot.ehr_backend.api.lipid_profile;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LipidProfileMapper {
    @Autowired
    private ModelMapper modelMapper;

    public LipidProfileDto mapToDto(LipidProfile lipidProfile) {
        return modelMapper.map(lipidProfile, LipidProfileDto.class);
    }

    public LipidProfile mapToEntity(LipidProfileDto lipidProfileDto) {
        return modelMapper.map(lipidProfileDto, LipidProfile.class);
    }
}
