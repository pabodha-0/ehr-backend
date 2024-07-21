package com.binary_dot.ehr_backend.api.patient;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);
    PatientDto findById(int id) throws NotFoundException;
    Page<PatientDto> findAll(int pageNo, int pageSize);
}
