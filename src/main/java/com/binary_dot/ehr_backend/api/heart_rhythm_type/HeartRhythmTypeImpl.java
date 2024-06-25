package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartRhythmTypeImpl implements HeartRhythmTypeService{
    @Autowired
    private HeartRhythmTypeRepository heartRhythmTypeRepository;

    @Autowired
    private HeartRhythmTypeMapper heartRhythmTypeMapper;

    @Override
    public HeartRhythmTypeDto addHeartRhythmType(HeartRhythmTypeDto heartRhythmTypeDto) {
        List<HeartRhythmType> existingHeartRhythmTypes = heartRhythmTypeRepository.findByName(heartRhythmTypeDto.getName());
        if(existingHeartRhythmTypes.isEmpty()){
            HeartRhythmType heartRhythmType = heartRhythmTypeRepository.save(heartRhythmTypeMapper.mapToEntity(heartRhythmTypeDto));
            return heartRhythmTypeMapper.mapToDto(heartRhythmType);
        }

        return heartRhythmTypeMapper.mapToDto(existingHeartRhythmTypes.getFirst());
    }

    @Override
    public HeartRhythmTypeDto findByID(int id) {
        return null;
    }

    @Override
    public List<HeartRhythmTypeDto> findAll() {
        return List.of();
    }
}
