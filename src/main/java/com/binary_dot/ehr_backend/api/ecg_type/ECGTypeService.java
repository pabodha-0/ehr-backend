package com.binary_dot.ehr_backend.api.ecg_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface ECGTypeService {
    ECGTypeDto createECGType(ECGTypeDto ecgTypeDto);
    ECGTypeDto findById(int id) throws NotFoundException;
    List<ECGTypeDto> findAll();
}
