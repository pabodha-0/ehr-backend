package com.binary_dot.ehr_backend.api.ear_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface EarInfectionTypeService {
    EarInfectionTypeDto addEarInfectionType(EarInfectionTypeDto earInfectionTypeDto);
    EarInfectionTypeDto findById(int id) throws NotFoundException;
    List<EarInfectionTypeDto> findAll();
}
