package com.binary_dot.ehr_backend.api.nose_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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
        if(noseInfectionTypeDto == null) {
            return null;
        }
        List<NoseInfectionType> existingNoseInfectionType = noseInfectionTypeRepository.findByName(noseInfectionTypeDto.getName());
        if (existingNoseInfectionType.isEmpty()) {
            NoseInfectionType noseInfectionType = noseInfectionTypeRepository.save(noseInfectionTypeMapper.mapToEntity(noseInfectionTypeDto));
            return noseInfectionTypeMapper.mapToDto(noseInfectionType);
        }

        return noseInfectionTypeMapper.mapToDto(existingNoseInfectionType.getFirst());
    }

    @Override
    public NoseInfectionTypeDto findById(int id) throws NotFoundException {
        NoseInfectionType noseInfectionType = noseInfectionTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found Nose Infection Type with Id"+ id)
        );
        return noseInfectionTypeMapper.mapToDto(noseInfectionType);
    }

    @Override
    public List<NoseInfectionTypeDto> findAll() {
        List<NoseInfectionType> noseInfectionTypeList = noseInfectionTypeRepository.findAll();
        return noseInfectionTypeList.stream().map(type -> noseInfectionTypeMapper.mapToDto(type)).toList();
    }
}
