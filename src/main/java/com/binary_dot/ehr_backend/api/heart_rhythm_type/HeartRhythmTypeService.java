package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import java.util.List;

public interface HeartRhythmTypeService {
    HeartRhythmTypeDto addHeartRhythmType(HeartRhythmTypeDto heartRhythmTypeDto);
    HeartRhythmTypeDto findByID(int id);
    List<HeartRhythmTypeDto> findAll();
}
