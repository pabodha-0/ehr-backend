package com.binary_dot.ehr_backend.api.ear_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EarInfectionTypeImpl implements EarInfectionTypeService {
    @Autowired
    private EarInfectionTypeRepository earInfectionTypeRepository;

    @Autowired
    private EarInfectionTypeMapper earInfectionTypeMapper;

    @Override
    public EarInfectionTypeDto addEarInfectionType(EarInfectionTypeDto earInfectionTypeDto) {
        if(earInfectionTypeDto == null) {
            return null;
        }
        List<EarInfectionType> existingEarInfectionType= earInfectionTypeRepository.findByName(earInfectionTypeDto.getName());

        if(existingEarInfectionType.isEmpty()){
            EarInfectionType earInfectionType = earInfectionTypeRepository.save(earInfectionTypeMapper.mapToEntity(earInfectionTypeDto));
            return earInfectionTypeMapper.mapToDto(earInfectionType);
        }

        return earInfectionTypeMapper.mapToDto(existingEarInfectionType.getFirst());
    }

    @Override
    public EarInfectionTypeDto findById(int id) throws NotFoundException {
        Optional<EarInfectionType> earInfectionType = earInfectionTypeRepository.findById(id);
        if(earInfectionType.isPresent()){
            return earInfectionTypeMapper.mapToDto(earInfectionType.get());
        }

        throw new NotFoundException("Ear Infection Type not found by Id: " + id);
    }

    @Override
    public List<EarInfectionTypeDto> findAll() {
        List<EarInfectionType> earInfectionTypeList = earInfectionTypeRepository.findAll();
        return earInfectionTypeList.stream().map(type -> earInfectionTypeMapper.mapToDto(type)).toList();
    }
}
