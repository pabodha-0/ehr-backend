package com.binary_dot.ehr_backend.api.nose_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface NoseInfectionTypeService {
    NoseInfectionTypeDto addNoseInfectionType(NoseInfectionTypeDto noseInfectionTypeDto);
    NoseInfectionTypeDto findById(int id) throws NotFoundException;
    List<NoseInfectionTypeDto> findAll();
}
