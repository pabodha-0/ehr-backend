package com.binary_dot.ehr_backend.api.food_allergy;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/food-allergy")
public class FoodAllergyController {
    @Autowired
    private FoodAllergyService foodAllergyService;

    @PostMapping()
    public ResponseEntity<FoodAllergyDto> createFoodAllergy(@Valid @RequestBody FoodAllergyDto foodAllergyDto) {
        return new ResponseEntity<>(foodAllergyService.addFoodAllergy(foodAllergyDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<FoodAllergyDto>> getAllFoodAllergies() {
        return new ResponseEntity<>(foodAllergyService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodAllergyDto> getFoodAllergyById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(foodAllergyService.findById(id), HttpStatus.FOUND);
    }
}
