package com.binary_dot.ehr_backend.api.nose_infection_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoseInfectionTypeImpl implements NoseInfectionTypeService {
    @Autowired
    NoseInfectionTypeRepository noseInfectionTypeRepository;

    @Autowired
    NoseInfectionTypeMapper noseInfectionTypeMapper;

    @Override
    public NoseInfectionTypeDto addNoseInfectionType(NoseInfectionTypeDto noseInfectionTypeDto) {
        List<NoseInfectionType> existingNoseInfectionType = noseInfectionTypeRepository.findByName(noseInfectionTypeDto.getName());
        if (existingNoseInfectionType.isEmpty()) {
            NoseInfectionType noseInfectionType = noseInfectionTypeRepository.save(noseInfectionTypeMapper.mapToEntity(noseInfectionTypeDto));
            return noseInfectionTypeMapper.mapToDto(noseInfectionType);
        }

        return noseInfectionTypeMapper.mapToDto(existingNoseInfectionType.getFirst());
    }

    @Override
    public NoseInfectionTypeDto findById(int id) {
        return null;
    }

    @Override
    public List<NoseInfectionTypeDto> findAll() {
        return List.of();
    }
}
