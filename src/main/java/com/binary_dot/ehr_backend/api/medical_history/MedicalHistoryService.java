package com.binary_dot.ehr_backend.api.medical_history;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryDto addMedicalHistory(MedicalHistoryDto medicalHistory);
    MedicalHistoryDto findById(int id) throws NotFoundException;
    List<MedicalHistoryDto> findAll();
}
