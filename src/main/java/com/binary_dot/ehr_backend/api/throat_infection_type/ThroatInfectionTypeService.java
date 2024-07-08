package com.binary_dot.ehr_backend.api.throat_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface ThroatInfectionTypeService {
    ThroatInfectionTypeDto addThroatInfectionType(ThroatInfectionTypeDto infectionTypeDto);
    ThroatInfectionTypeDto findById(int id) throws NotFoundException;
    List<ThroatInfectionTypeDto> findAll();
}
