package com.binary_dot.ehr_backend.api.medical_history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryImpl implements MedicalHistoryService{
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private MedicalHistoryMapper medicalHistoryMapper;

    @Override
    public MedicalHistoryDto addMedicalHistory(MedicalHistoryDto medicalHistoryDto) {
        MedicalHistory medicalHistory = medicalHistoryRepository.save(medicalHistoryMapper.mapToEntity(medicalHistoryDto));
        return medicalHistoryMapper.mapToDto(medicalHistory);
    }
}
