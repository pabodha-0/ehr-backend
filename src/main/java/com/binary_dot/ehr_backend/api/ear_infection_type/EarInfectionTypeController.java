package com.binary_dot.ehr_backend.api.ear_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/ear-infection")
public class EarInfectionTypeController {
    @Autowired
    private EarInfectionTypeService earInfectionTypeService;

    @PostMapping()
    public ResponseEntity<EarInfectionTypeDto> createEarInfectionType(@Valid @RequestBody EarInfectionTypeDto earInfectionTypeDto) {
        return new ResponseEntity<>(earInfectionTypeService.addEarInfectionType(earInfectionTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EarInfectionTypeDto>> getAllEarInfectionTypes() {
        return new ResponseEntity<>(earInfectionTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EarInfectionTypeDto> getEarInfectionTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(earInfectionTypeService.findById(id), HttpStatus.FOUND);
    }
}
