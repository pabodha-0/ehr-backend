package com.binary_dot.ehr_backend.api.ecg_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECGTypeImpl implements ECGTypeService{
    @Autowired
    private ECGTypeRepository ecgTypeRepository;

    @Autowired
    private ECGTypeMapper ecgTypeMapper;

    @Override
    public ECGTypeDto createECGType(ECGTypeDto ecgTypeDto) {
        List<ECGType> existingECGType = ecgTypeRepository.findByName(ecgTypeDto.getName());
        if (existingECGType.isEmpty()) {
            ECGType ecgType = ecgTypeRepository.save(ecgTypeMapper.mapToEntity(ecgTypeDto));
            return ecgTypeMapper.mapToDto(ecgType);
        }

        return ecgTypeMapper.mapToDto(existingECGType.getFirst());
    }

    @Override
    public ECGTypeDto findById(int id) throws NotFoundException {
        Optional<ECGType> ecgType = ecgTypeRepository.findById(id);
        if(ecgType.isPresent()) {
            return ecgTypeMapper.mapToDto(ecgType.get());
        }

        throw new NotFoundException("ECG type not found by id");
    }

    @Override
    public List<ECGTypeDto> findAll() {
        List<ECGType> ecgTypeList = ecgTypeRepository.findAll();
        return ecgTypeList.stream().map(type -> ecgTypeMapper.mapToDto(type)).toList();
    }
}
