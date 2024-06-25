package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abdomen-infection-type")
public class AbdomenInfectionTypeController {
    @Autowired
    AbdomenInfectionTypeService abdomenInfectionTypeService;

    @PostMapping()
    public ResponseEntity<AbdomenInfectionTypeDto> addAbdomenInfectionType(@Valid @RequestBody AbdomenInfectionTypeDto type) {
        return new ResponseEntity<>(abdomenInfectionTypeService.addAbdomenInfectionType(type), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AbdomenInfectionTypeDto>> getAllAbdomenInfectionTypes() {
        return new ResponseEntity<>(abdomenInfectionTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbdomenInfectionTypeDto> findAbdomenInfectionTypeById(@PathVariable("id") int id) throws NotFoundException {
        return abdomenInfectionTypeService.findById(id);
    }
    
}
