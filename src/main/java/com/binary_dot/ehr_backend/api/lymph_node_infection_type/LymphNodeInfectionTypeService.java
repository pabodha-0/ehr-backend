package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

import java.util.List;

public interface LymphNodeInfectionTypeService {
    LymphNodeInfectionTypeDto addLymphNodeInfectionType(LymphNodeInfectionTypeDto lymphNodeInfectionType);
    LymphNodeInfectionTypeDto findById(int id);
    List<LymphNodeInfectionTypeDto> findAll();
}
