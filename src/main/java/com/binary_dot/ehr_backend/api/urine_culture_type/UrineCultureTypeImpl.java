package com.binary_dot.ehr_backend.api.urine_culture_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
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
        if(urineCultureTypeDto == null) {
            return null;
        }
        List<UrineCultureType> existingUrineCultureType = urineCultureTypeRepository.findByName(urineCultureTypeDto.getName());
        if(existingUrineCultureType.isEmpty()) {
            UrineCultureType urineCultureType = urineCultureTypeRepository.save(urineCultureTypeMapper.mapToEntity(urineCultureTypeDto));
            return urineCultureTypeMapper.mapToDto(urineCultureType);
        }

        return urineCultureTypeMapper.mapToDto(existingUrineCultureType.getFirst());
    }

    @Override
    public UrineCultureTypeDto findById(int id) throws NotFoundException {
        UrineCultureType urineCultureType = urineCultureTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found Urine Culture Type with Id: " + id)
        );
        return urineCultureTypeMapper.mapToDto(urineCultureType);
    }

    @Override
    public List<UrineCultureTypeDto> findAll() {
        List<UrineCultureType> urineCultureTypes = urineCultureTypeRepository.findAll();
        return urineCultureTypes.stream().map(type -> urineCultureTypeMapper.mapToDto(type)).toList();
    }
}
