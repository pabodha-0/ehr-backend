package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/heart-rhythm-type")
public class HeartRhythmTypeController {
    @Autowired
    private HeartRhythmTypeService heartRhythmTypeService;

    @PostMapping()
    public ResponseEntity<HeartRhythmTypeDto> createHeartRhythmType(@Valid @RequestBody HeartRhythmTypeDto heartRhythmTypeDto) {
        return new ResponseEntity<>(heartRhythmTypeService.addHeartRhythmType(heartRhythmTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<HeartRhythmTypeDto>> getAllHeartRhythmTypes() {
        return new ResponseEntity<>(heartRhythmTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeartRhythmTypeDto> getHeartRhythmTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(heartRhythmTypeService.findById(id), HttpStatus.OK);
    }
}
