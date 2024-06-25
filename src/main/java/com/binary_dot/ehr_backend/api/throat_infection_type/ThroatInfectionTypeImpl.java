package com.binary_dot.ehr_backend.api.throat_infection_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThroatInfectionTypeImpl implements ThroatInfectionTypeService{
    @Autowired
    private ThroatInfectionTypeRepository throatInfectionTypeRepository;

    @Autowired
    private ThroatInfectionTypeMapper throatInfectionTypeMapper;

    @Override
    public ThroatInfectionTypeDto addThroatInfectionType(ThroatInfectionTypeDto throatInfectionTypeDto) {
        List<ThroatInfectionType> existingThroatInfectionType = throatInfectionTypeRepository.findByName(throatInfectionTypeDto.getName());
        if(existingThroatInfectionType.isEmpty()){
            ThroatInfectionType throatInfectionType = throatInfectionTypeRepository.save(throatInfectionTypeMapper.mapToEntity(throatInfectionTypeDto));
            return throatInfectionTypeMapper.mapToDto(throatInfectionType);
        }

        return throatInfectionTypeMapper.mapToDto(existingThroatInfectionType.getFirst());
    }

    @Override
    public ThroatInfectionTypeDto findById(Long id) {
        return null;
    }

    @Override
    public List<ThroatInfectionTypeDto> findAll() {
        return List.of();
    }
}
