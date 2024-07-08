package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface LymphNodeInfectionTypeService {
    LymphNodeInfectionTypeDto addLymphNodeInfectionType(LymphNodeInfectionTypeDto lymphNodeInfectionType);
    LymphNodeInfectionTypeDto findById(int id) throws NotFoundException;
    List<LymphNodeInfectionTypeDto> findAll();
}
