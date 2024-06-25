package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping()
    public ResponseEntity<AppointmentDto> addAbdomenInfectionType(@Valid @RequestBody AppointmentDto type) {
        return new ResponseEntity<>(appointmentService.addEntry(type), HttpStatus.CREATED);
    }

//    @GetMapping()
//    public ResponseEntity<List<AbdomenInfectionType.AbdomenInfectionTypeDto>> addAbdomenInfectionType() {
//        return new ResponseEntity<>(abdomenInfectionTypeService.findAll(), HttpStatus.FOUND);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AbdomenInfectionType.AbdomenInfectionTypeDto> addAbdomenInfectionType(@PathVariable("id") int id) throws NotFoundException {
//        return abdomenInfectionTypeService.findById(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(appointmentService.findById(id));
    }
    
}
