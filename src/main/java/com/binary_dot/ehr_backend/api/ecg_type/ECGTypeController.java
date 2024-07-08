package com.binary_dot.ehr_backend.api.ecg_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/ecg-type")
public class ECGTypeController {
    @Autowired
    private ECGTypeService ecgTypeService;

    @PostMapping()
    public ResponseEntity<ECGTypeDto> createECGType(@Valid @RequestBody ECGTypeDto ecgTypeDto) {
        return new ResponseEntity<>(ecgTypeService.createECGType(ecgTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ECGTypeDto>> getAllECGTypes() {
        return new ResponseEntity<>(ecgTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ECGTypeDto> getECGTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(ecgTypeService.findById(id), HttpStatus.FOUND);
    }
}
