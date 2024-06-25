package com.binary_dot.ehr_backend.api.urine_culture_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrineCultureTypeImpl implements UrineCultureTypeService{
    @Autowired
    private UrineCultureTypeRepository urineCultureTypeRepository;

    @Autowired
    private UrineCultureTypeMapper urineCultureTypeMapper;

    @Override
    public UrineCultureTypeDto createUrineCultureType(UrineCultureTypeDto urineCultureTypeDto) {
        List<UrineCultureType> existingUrineCultureType = urineCultureTypeRepository.findByName(urineCultureTypeDto.getName());
        if(existingUrineCultureType.isEmpty()) {
            UrineCultureType urineCultureType = urineCultureTypeRepository.save(urineCultureTypeMapper.mapToEntity(urineCultureTypeDto));
            return urineCultureTypeMapper.mapToDto(urineCultureType);
        }

        return urineCultureTypeMapper.mapToDto(existingUrineCultureType.getFirst());
    }

    @Override
    public UrineCultureTypeDto findById(int id) {
        return null;
    }

    @Override
    public List<UrineCultureTypeDto> findAll() {
        return List.of();
    }
}
