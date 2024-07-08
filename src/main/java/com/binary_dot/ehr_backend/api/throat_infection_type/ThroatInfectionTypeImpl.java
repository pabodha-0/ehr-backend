package com.binary_dot.ehr_backend.api.throat_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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
    public ThroatInfectionTypeDto findById(int id) throws NotFoundException {
        ThroatInfectionType throatInfectionType = throatInfectionTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found Throat Infection Type with Id " + id)
        );
        return throatInfectionTypeMapper.mapToDto(throatInfectionType);
    }

    @Override
    public List<ThroatInfectionTypeDto> findAll() {
        List<ThroatInfectionType> throatInfectionTypeList = throatInfectionTypeRepository.findAll();
        return throatInfectionTypeList.stream().map(type -> throatInfectionTypeMapper.mapToDto(type)).toList();
    }
}
