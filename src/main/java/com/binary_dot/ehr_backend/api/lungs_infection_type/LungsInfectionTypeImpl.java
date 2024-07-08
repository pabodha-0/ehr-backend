package com.binary_dot.ehr_backend.api.lungs_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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
    public LungsInfectionTypeDto findById(int id) throws NotFoundException {
        LungsInfectionType lungsInfectionType = lungsInfectionTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Lungs Infection Type not found with id: " + id)
        );
        return lungsInfectionTypeMapper.mapToDto(lungsInfectionType);
    }

    @Override
    public List<LungsInfectionTypeDto> findAll() {
        List<LungsInfectionType> lungsInfectionTypes = lungsInfectionTypeRepository.findAll();
        return lungsInfectionTypes.stream().map(type -> lungsInfectionTypeMapper.mapToDto(type)).toList();
    }
}
