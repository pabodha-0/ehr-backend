package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping()
    public ResponseEntity<AppointmentDto> addAppointment(@Valid @RequestBody AppointmentDto type) {
        return new ResponseEntity<>(appointmentService.addEntry(type), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.findAll(), HttpStatus.FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(appointmentService.findById(id), HttpStatus.FOUND);
    }
    
}
