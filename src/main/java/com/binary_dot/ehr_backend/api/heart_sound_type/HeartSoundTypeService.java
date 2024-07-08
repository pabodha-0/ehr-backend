package com.binary_dot.ehr_backend.api.heart_sound_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface HeartSoundTypeService {
    HeartSoundTypeDto addHeartSoundType(HeartSoundTypeDto heartSoundTypeDto);
    HeartSoundTypeDto findById(int id) throws NotFoundException;
    List<HeartSoundTypeDto> findAll();
}
