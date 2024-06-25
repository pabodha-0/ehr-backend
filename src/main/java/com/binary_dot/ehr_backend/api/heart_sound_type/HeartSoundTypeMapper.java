package com.binary_dot.ehr_backend.api.heart_sound_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeartSoundTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public HeartSoundTypeDto mapToDto(HeartSoundType heartSoundType) {
        return modelMapper.map(heartSoundType, HeartSoundTypeDto.class);
    }

    public HeartSoundType mapToEntity(HeartSoundTypeDto heartSoundTypeDto) {
        return modelMapper.map(heartSoundTypeDto, HeartSoundType.class);
    }
}
