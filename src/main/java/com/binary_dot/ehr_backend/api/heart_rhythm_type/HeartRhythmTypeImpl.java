package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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
        if(heartRhythmTypeDto == null) {
            return null;
        }
        List<HeartRhythmType> existingHeartRhythmTypes = heartRhythmTypeRepository.findByName(heartRhythmTypeDto.getName());
        if(existingHeartRhythmTypes.isEmpty()){
            HeartRhythmType heartRhythmType = heartRhythmTypeRepository.save(heartRhythmTypeMapper.mapToEntity(heartRhythmTypeDto));
            return heartRhythmTypeMapper.mapToDto(heartRhythmType);
        }

        return heartRhythmTypeMapper.mapToDto(existingHeartRhythmTypes.getFirst());
    }

    @Override
    public HeartRhythmTypeDto findById(int id) throws NotFoundException {
        HeartRhythmType heartRhythmType = heartRhythmTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found HeartRhythmType with id " + id)
        );
        return heartRhythmTypeMapper.mapToDto(heartRhythmType);
    }

    @Override
    public List<HeartRhythmTypeDto> findAll() {
        List<HeartRhythmType> heartRhythmTypes = heartRhythmTypeRepository.findAll();
        return heartRhythmTypes.stream().map(type -> heartRhythmTypeMapper.mapToDto(type)).toList();
    }
}
