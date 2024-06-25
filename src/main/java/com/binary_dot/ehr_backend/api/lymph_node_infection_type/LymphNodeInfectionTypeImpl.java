package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LymphNodeInfectionTypeImpl implements LymphNodeInfectionTypeService{
    @Autowired
    LymphNodeInfectionTypeRepository lymphNodeInfectionTypeRepository;

    @Autowired
    LymphNodeInfectionTypeMapper lymphNodeInfectionTypeMapper;

    @Override
    public LymphNodeInfectionTypeDto addLymphNodeInfectionType(LymphNodeInfectionTypeDto lymphNodeInfectionTypeDto) {
        List<LymphNodeInfectionType> existingLymphNodeInfectionType = lymphNodeInfectionTypeRepository.findByName(lymphNodeInfectionTypeDto.getName());
        if(existingLymphNodeInfectionType.isEmpty()) {
            LymphNodeInfectionType lymphNodeInfectionType = lymphNodeInfectionTypeRepository.save(lymphNodeInfectionTypeMapper.mapToEntity(lymphNodeInfectionTypeDto));
            return lymphNodeInfectionTypeMapper.mapToDto(lymphNodeInfectionType);
        }

        return lymphNodeInfectionTypeMapper.mapToDto(existingLymphNodeInfectionType.getFirst());
    }

    @Override
    public LymphNodeInfectionTypeDto findById(int id) {
        return null;
    }

    @Override
    public List<LymphNodeInfectionTypeDto> findAll() {
        return List.of();
    }
}
