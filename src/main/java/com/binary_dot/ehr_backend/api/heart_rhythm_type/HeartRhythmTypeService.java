package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface HeartRhythmTypeService {
    HeartRhythmTypeDto addHeartRhythmType(HeartRhythmTypeDto heartRhythmTypeDto);
    HeartRhythmTypeDto findById(int id) throws NotFoundException;
    List<HeartRhythmTypeDto> findAll();
}
