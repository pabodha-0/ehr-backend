package com.binary_dot.ehr_backend.api.patient;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findPatientById(@PathVariable("id") int id) throws NotFoundException {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<PatientDto>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @PostMapping()
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(patientService.addPatient(patientDto));
    }
}
