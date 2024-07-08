package com.binary_dot.ehr_backend.api.urine_culture_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface UrineCultureTypeService {
    UrineCultureTypeDto createUrineCultureType(UrineCultureTypeDto urineCultureTypeDto);
    UrineCultureTypeDto findById(int id) throws NotFoundException;
    List<UrineCultureTypeDto> findAll();
}
