package com.binary_dot.ehr_backend.api.drug_manufacturer;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/drug-manufacturer")
public class DrugManufacturerController {
    @Autowired
    DrugManufacturerService drugManufacturerService;

    @PostMapping()
    public ResponseEntity<DrugManufacturerDto> addDrugManufacturer(@Valid @RequestBody DrugManufacturerDto type) {
        return new ResponseEntity<>(drugManufacturerService.createDrugManufacturer(type), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DrugManufacturerDto>> getAllAppointments(@RequestParam(required = false) String drugName) {
        return new ResponseEntity<>(drugManufacturerService.findAll(drugName), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DrugManufacturerDto> getAppointmentById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(drugManufacturerService.findById(id), HttpStatus.OK);
    }
}
