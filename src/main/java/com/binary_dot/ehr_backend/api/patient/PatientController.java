package com.binary_dot.ehr_backend.api.patient;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findPatientById(@PathVariable("id") int id) throws NotFoundException {
        return new ResponseEntity<>(patientService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<PatientDto>> findAllPatients(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "0") int pageSize
    ) {
        return new ResponseEntity<>(patientService.findAll(pageNo, pageSize), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);
    }
}
