package com.binary_dot.ehr_backend.api.heart_sound_type;

import java.util.List;

public interface HeartSoundTypeService {
    HeartSoundTypeDto addHeartSoundType(HeartSoundTypeDto heartSoundTypeDto);
    HeartSoundTypeDto findById(int id);
    List<HeartSoundTypeDto> findAll();
}
