package com.binary_dot.ehr_backend.api.drug_info;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/drug-info")
public class DrugInfoController {
    @Autowired
    DrugInfoService drugInfoService;

    @PostMapping()
    public ResponseEntity<DrugInfoDto> addDrugInfo(@Valid @RequestBody DrugInfoDto type) {
        return new ResponseEntity<>(drugInfoService.createDrugInfo(type), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DrugInfoDto>> getAllDrugInfo(
            @RequestParam(required = false) String drugName,
            @RequestParam(required = false) String manufacturerName,
            @RequestParam(required = false) String drugDosage,
            @RequestParam(required = false) String drugExpDate
    ) {
        return new ResponseEntity<>(drugInfoService.findAll(drugName, manufacturerName, drugDosage, drugExpDate), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DrugInfoDto> getDrugInfoById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(drugInfoService.findById(id), HttpStatus.OK);
    }
}
