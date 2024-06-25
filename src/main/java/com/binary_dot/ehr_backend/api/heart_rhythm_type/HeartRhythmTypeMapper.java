package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeartRhythmTypeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public HeartRhythmTypeDto mapToDto(HeartRhythmType heartRhythmType) {
        return modelMapper.map(heartRhythmType, HeartRhythmTypeDto.class);
    }

    public HeartRhythmType mapToEntity(HeartRhythmTypeDto heartRhythmTypeDto) {
        return modelMapper.map(heartRhythmTypeDto, HeartRhythmType.class);
    }
}
