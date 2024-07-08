package com.binary_dot.ehr_backend.api.throat_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/throat-infection-type")
public class ThroatInfectionTypeController {
    @Autowired
    private ThroatInfectionTypeService throatInfectionTypeService;

    @PostMapping()
    public ResponseEntity<ThroatInfectionTypeDto> createThroatInfectionType(@Valid @RequestBody ThroatInfectionTypeDto throatInfectionTypeDto) {
        return new ResponseEntity<>(throatInfectionTypeService.addThroatInfectionType(throatInfectionTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ThroatInfectionTypeDto>> getAllThroatInfectionTypes() {
        return new ResponseEntity<>(throatInfectionTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThroatInfectionTypeDto> getThroatInfectionTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(throatInfectionTypeService.findById(id), HttpStatus.FOUND);
    }
}
