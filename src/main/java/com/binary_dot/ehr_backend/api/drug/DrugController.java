package com.binary_dot.ehr_backend.api.drug;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/drug")
public class DrugController {
    @Autowired
    DrugService drugService;

    @PostMapping()
    public ResponseEntity<DrugDto> addAppointment(@Valid @RequestBody DrugDto type) {
        return new ResponseEntity<>(drugService.createDrug(type), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DrugDto>> getAllAppointments(@RequestParam(required = false) String manufacturerName) {
        return new ResponseEntity<>(drugService.findAll(manufacturerName), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DrugDto> getAppointmentById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(drugService.findById(id), HttpStatus.OK);
    }
}
