package com.binary_dot.ehr_backend.api.heart_sound_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/heart-sound-type")
public class HeartSoundTypeController {
    @Autowired
    private HeartSoundTypeService heartSoundTypeService;

    @PostMapping()
    public ResponseEntity<HeartSoundTypeDto> createHeartSoundType(@Valid @RequestBody HeartSoundTypeDto heartSoundTypeDto) {
        return new ResponseEntity<>(heartSoundTypeService.addHeartSoundType(heartSoundTypeDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<HeartSoundTypeDto>> getAllHeartSoundTypes() {
        return new ResponseEntity<>(heartSoundTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeartSoundTypeDto> getHeartSoundTypeById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(heartSoundTypeService.findById(id), HttpStatus.OK);
    }
}
