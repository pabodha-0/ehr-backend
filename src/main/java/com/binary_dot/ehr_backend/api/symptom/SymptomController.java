package com.binary_dot.ehr_backend.api.symptom;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/symptom")
public class SymptomController {
    @Autowired
    private SymptomService symptomService;

    @PostMapping()
    public ResponseEntity<SymptomDto> createSymptom(@Valid @RequestBody SymptomDto symptomDto) {
        return new ResponseEntity<>(symptomService.addSymptom(symptomDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<SymptomDto>> getAllSymptoms() {
        return new ResponseEntity<>(symptomService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SymptomDto> getSymptomById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(symptomService.findById(id), HttpStatus.OK);
    }
}
