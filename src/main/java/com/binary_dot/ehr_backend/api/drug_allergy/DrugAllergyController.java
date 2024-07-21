package com.binary_dot.ehr_backend.api.drug_allergy;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/drug-allergy")
public class DrugAllergyController {
    @Autowired
    private DrugAllergyService drugAllergyService;

    @PostMapping()
    public ResponseEntity<DrugAllergyDto> createDrugAllergy(@Valid @RequestBody DrugAllergyDto drugAllergyDto) {
        return new ResponseEntity<>(drugAllergyService.addDrugAllergy(drugAllergyDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DrugAllergyDto>> getAllDrugAllergies() {
        return new ResponseEntity<>(drugAllergyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugAllergyDto> getDrugAllergyById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(drugAllergyService.findById(id), HttpStatus.OK);
    }
}
