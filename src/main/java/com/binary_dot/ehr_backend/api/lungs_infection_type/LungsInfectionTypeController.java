package com.binary_dot.ehr_backend.api.lungs_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/lungs-infection-type")
public class LungsInfectionTypeController {
    @Autowired
    private LungsInfectionTypeService lungsInfectionTypeService;

    @PostMapping()
    public ResponseEntity<LungsInfectionTypeDto> createLungsInfectionType(@Valid @RequestBody LungsInfectionTypeDto lungsInfectionTypeDto) {
        return new ResponseEntity<>(lungsInfectionTypeService.addLungsInfectionType(lungsInfectionTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<LungsInfectionTypeDto>> getAllLungsInfectionTypes() {
        return new ResponseEntity<>(lungsInfectionTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LungsInfectionTypeDto> getLungsInfectionTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(lungsInfectionTypeService.findById(id), HttpStatus.FOUND);
    }
}
