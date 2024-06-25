package com.binary_dot.ehr_backend.api.ecg_type;

import java.util.List;

public interface ECGTypeService {
    ECGTypeDto createECGType(ECGTypeDto ecgTypeDto);
    ECGTypeDto findById(int id);
    List<ECGTypeDto> findAll();
}
