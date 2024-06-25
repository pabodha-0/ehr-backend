package com.binary_dot.ehr_backend.api.heart_sound_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartSoundTypeImpl implements HeartSoundTypeService{
    @Autowired
    private HeartSoundTypeRepository heartSoundTypeRepository;

    @Autowired
    private HeartSoundTypeMapper heartSoundTypeMapper;

    @Override
    public HeartSoundTypeDto addHeartSoundType(HeartSoundTypeDto heartSoundTypeDto) {
        List<HeartSoundType> existingHeartSoundType = heartSoundTypeRepository.findByName(heartSoundTypeDto.getName());
        if (existingHeartSoundType.isEmpty()) {
            HeartSoundType heartSoundType = heartSoundTypeRepository.save(heartSoundTypeMapper.mapToEntity(heartSoundTypeDto));
            return heartSoundTypeMapper.mapToDto(heartSoundType);
        }

        return heartSoundTypeMapper.mapToDto(existingHeartSoundType.getFirst());
    }

    @Override
    public HeartSoundTypeDto findById(int id) {
        return null;
    }

    @Override
    public List<HeartSoundTypeDto> findAll() {
        return List.of();
    }
}
