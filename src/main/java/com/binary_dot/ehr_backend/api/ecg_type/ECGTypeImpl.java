package com.binary_dot.ehr_backend.api.ecg_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ECGTypeDto findById(int id) {
        return null;
    }

    @Override
    public List<ECGTypeDto> findAll() {
        return List.of();
    }
}
