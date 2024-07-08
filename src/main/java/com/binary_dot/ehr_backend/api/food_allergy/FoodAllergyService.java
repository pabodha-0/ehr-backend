package com.binary_dot.ehr_backend.api.food_allergy;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface FoodAllergyService {
    FoodAllergyDto addFoodAllergy(FoodAllergyDto foodAllergyDto);
    List<FoodAllergyDto> addFoodAllergies(List<FoodAllergyDto> foodAllergyDtoList);
    FoodAllergyDto findById(int id) throws NotFoundException;
    List<FoodAllergyDto> findAll();
}
