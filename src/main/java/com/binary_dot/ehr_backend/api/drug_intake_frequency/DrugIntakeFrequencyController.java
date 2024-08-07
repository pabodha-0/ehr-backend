package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/drug-intake-frequency")
public class DrugIntakeFrequencyController {
    @Autowired
    DrugIntakeFrequencyService drugIntakeFrequencyService;

    @PostMapping()
    public ResponseEntity<DrugIntakeFrequencyDto> addDrugIntakeFrequency(@Valid @RequestBody DrugIntakeFrequencyDto type) {
        return new ResponseEntity<>(drugIntakeFrequencyService.createDrugIntakeFrequency(type), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DrugIntakeFrequencyDto>> getAllDrugIntakeFrequencies() {
        return new ResponseEntity<>(drugIntakeFrequencyService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DrugIntakeFrequencyDto> getDrugIntakeFrequencyById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(drugIntakeFrequencyService.findById(id), HttpStatus.OK);
    }
}
