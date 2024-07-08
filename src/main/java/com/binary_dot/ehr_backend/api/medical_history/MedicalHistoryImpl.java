package com.binary_dot.ehr_backend.api.medical_history;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public MedicalHistoryDto findById(int id) throws NotFoundException {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Medical history not found by Id: " + id)
        );
        return medicalHistoryMapper.mapToDto(medicalHistory);
    }

    @Override
    public List<MedicalHistoryDto> findAll() {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findAll();
        return medicalHistories.stream().map(history -> medicalHistoryMapper.mapToDto(history)).toList();
    }
}
