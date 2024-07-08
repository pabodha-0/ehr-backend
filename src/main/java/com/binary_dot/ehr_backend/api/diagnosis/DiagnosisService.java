package com.binary_dot.ehr_backend.api.diagnosis;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface DiagnosisService {
    DiagnosisDto createDiagnosis(DiagnosisDto diagnosisDto);
    List<DiagnosisDto> createDiagnoses(List<DiagnosisDto> diagnosisDtoList);
    DiagnosisDto findById(int id) throws NotFoundException;
    List<DiagnosisDto> findAll();
}
