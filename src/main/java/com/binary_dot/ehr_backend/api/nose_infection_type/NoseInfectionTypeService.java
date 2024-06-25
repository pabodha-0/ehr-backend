package com.binary_dot.ehr_backend.api.nose_infection_type;

import java.util.List;

public interface NoseInfectionTypeService {
    NoseInfectionTypeDto addNoseInfectionType(NoseInfectionTypeDto noseInfectionTypeDto);
    NoseInfectionTypeDto findById(int id);
    List<NoseInfectionTypeDto> findAll();
}
