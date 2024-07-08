package com.binary_dot.ehr_backend.api.lungs_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface LungsInfectionTypeService {
    LungsInfectionTypeDto addLungsInfectionType(LungsInfectionTypeDto lungsInfectionTypeDto);
    LungsInfectionTypeDto findById(int id) throws NotFoundException;
    List<LungsInfectionTypeDto> findAll();
}
