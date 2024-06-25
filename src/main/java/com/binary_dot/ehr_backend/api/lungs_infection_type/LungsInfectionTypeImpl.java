package com.binary_dot.ehr_backend.api.lungs_infection_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LungsInfectionTypeImpl implements LungsInfectionTypeService{
    @Autowired
    private LungsInfectionTypeRepository lungsInfectionTypeRepository;

    @Autowired
    private LungsInfectionTypeMapper lungsInfectionTypeMapper;

    @Override
    public LungsInfectionTypeDto addLungsInfectionType(LungsInfectionTypeDto lungsInfectionTypeDto) {
        List<LungsInfectionType> existingLungsInfectionTypes = lungsInfectionTypeRepository.findByName(lungsInfectionTypeDto.getName());
        if(existingLungsInfectionTypes.isEmpty()){
            LungsInfectionType lungsInfectionType = lungsInfectionTypeRepository.save(lungsInfectionTypeMapper.mapToEntity(lungsInfectionTypeDto));
            return lungsInfectionTypeMapper.mapToDto(lungsInfectionType);
        }

        return lungsInfectionTypeMapper.mapToDto(existingLungsInfectionTypes.getFirst());
    }

    @Override
    public LungsInfectionTypeDto findById(int id) {
        return null;
    }

    @Override
    public List<LungsInfectionTypeDto> findAll() {
        return List.of();
    }
}
