package com.binary_dot.ehr_backend.api.urine_culture_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/urine-culture-type")
public class UrineCultureTypeController {
    @Autowired
    private UrineCultureTypeService urineCultureTypeService;

    @PostMapping()
    public ResponseEntity<UrineCultureTypeDto> createUrineCultureType(@Valid @RequestBody UrineCultureTypeDto urineCultureTypeDto) {
        return new ResponseEntity<>(urineCultureTypeService.createUrineCultureType(urineCultureTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UrineCultureTypeDto>> getAllUrineCultureTypes() {
        return new ResponseEntity<>(urineCultureTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UrineCultureTypeDto> getUrineCultureTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(urineCultureTypeService.findById(id), HttpStatus.FOUND);
    }
}
