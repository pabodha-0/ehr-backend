package com.binary_dot.ehr_backend.api.nose_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/nose-infection-type")
public class NoseInfectionTypeController {
    @Autowired
    private NoseInfectionTypeService noseInfectionTypeService;

    @PostMapping()
    public ResponseEntity<NoseInfectionTypeDto> createNoseInfectionType(@Valid @RequestBody NoseInfectionTypeDto noseInfectionTypeDto) {
        return new ResponseEntity<>(noseInfectionTypeService.addNoseInfectionType(noseInfectionTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<NoseInfectionTypeDto>> getAllNoseInfectionTypes() {
        return new ResponseEntity<>(noseInfectionTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoseInfectionTypeDto> getNoseInfectionTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(noseInfectionTypeService.findById(id), HttpStatus.OK);
    }
}
