package com.binary_dot.ehr_backend.api.diagnosis;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/diagnosis")
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping()
    public ResponseEntity<DiagnosisDto> createDiagnosis(@Valid @RequestBody DiagnosisDto diagnosisDto) {
        return new ResponseEntity<>(diagnosisService.createDiagnosis(diagnosisDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DiagnosisDto>> getAllDiagnoses() {
        return new ResponseEntity<>(diagnosisService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosisDto> getDiagnosisById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(diagnosisService.findById(id), HttpStatus.FOUND);
    }
}
