package com.binary_dot.ehr_backend.api.heart_sound_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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
        if(heartSoundTypeDto == null) {
            return null;
        }
        List<HeartSoundType> existingHeartSoundType = heartSoundTypeRepository.findByName(heartSoundTypeDto.getName());
        if (existingHeartSoundType.isEmpty()) {
            HeartSoundType heartSoundType = heartSoundTypeRepository.save(heartSoundTypeMapper.mapToEntity(heartSoundTypeDto));
            return heartSoundTypeMapper.mapToDto(heartSoundType);
        }

        return heartSoundTypeMapper.mapToDto(existingHeartSoundType.getFirst());
    }

    @Override
    public HeartSoundTypeDto findById(int id) throws NotFoundException {
        HeartSoundType heartSoundType = heartSoundTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found HeartSoundType with id " + id )
        );
        return heartSoundTypeMapper.mapToDto(heartSoundType);
    }

    @Override
    public List<HeartSoundTypeDto> findAll() {
        List<HeartSoundType> heartSoundTypes = heartSoundTypeRepository.findAll();
        return heartSoundTypes.stream().map(type -> heartSoundTypeMapper.mapToDto(type)).toList();
    }
}
