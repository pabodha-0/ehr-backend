package com.binary_dot.ehr_backend.api.ear_infection_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarInfectionTypeImpl implements EarInfectionTypeService {
    @Autowired
    private EarInfectionTypeRepository earInfectionTypeRepository;

    @Autowired
    private EarInfectionTypeMapper earInfectionTypeMapper;

    @Override
    public EarInfectionTypeDto addEarInfectionType(EarInfectionTypeDto earInfectionTypeDto) {
        List<EarInfectionType> existingEarInfectionType= earInfectionTypeRepository.findByName(earInfectionTypeDto.getName());

        if(existingEarInfectionType.isEmpty()){
            EarInfectionType earInfectionType = earInfectionTypeRepository.save(earInfectionTypeMapper.mapToEntity(earInfectionTypeDto));
            return earInfectionTypeMapper.mapToDto(earInfectionType);
        }

        return earInfectionTypeMapper.mapToDto(existingEarInfectionType.getFirst());
    }

    @Override
    public EarInfectionTypeDto findById(int id) {

        return null;
    }

    @Override
    public List<EarInfectionTypeDto> findAll() {
        return List.of();
    }
}
