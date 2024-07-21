package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/lymph-node-infection-type")
public class LymphNodeInfectionTypeController {
    @Autowired
    private LymphNodeInfectionTypeService lymphNodeInfectionTypeService;

    @PostMapping()
    public ResponseEntity<LymphNodeInfectionTypeDto> createLymphNodeInfectionType(@Valid @RequestBody LymphNodeInfectionTypeDto lymphNodeInfectionTypeDto) {
        return new ResponseEntity<>(lymphNodeInfectionTypeService.addLymphNodeInfectionType(lymphNodeInfectionTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<LymphNodeInfectionTypeDto>> getAllLymphNodeInfectionTypes() {
        return new ResponseEntity<>(lymphNodeInfectionTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LymphNodeInfectionTypeDto> getLymphNodeInfectionTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(lymphNodeInfectionTypeService.findById(id), HttpStatus.OK);
    }
}
