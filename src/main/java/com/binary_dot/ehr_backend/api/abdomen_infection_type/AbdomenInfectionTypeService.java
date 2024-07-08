package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AbdomenInfectionTypeService {
    AbdomenInfectionTypeDto addAbdomenInfectionType(AbdomenInfectionTypeDto abdomenInfectionTypeDto);
    List<AbdomenInfectionTypeDto> findAll();
    AbdomenInfectionTypeDto findById(int id) throws NotFoundException;
}
