package com.binary_dot.ehr_backend.api.throat_infection_type;

import java.util.List;

public interface ThroatInfectionTypeService {
    ThroatInfectionTypeDto addThroatInfectionType(ThroatInfectionTypeDto infectionTypeDto);
    ThroatInfectionTypeDto findById(Long id);
    List<ThroatInfectionTypeDto> findAll();
}
