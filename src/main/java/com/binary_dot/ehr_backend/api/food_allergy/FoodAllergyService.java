package com.binary_dot.ehr_backend.api.food_allergy;

import java.util.List;

public interface FoodAllergyService {
    FoodAllergyDto addFoodAllergy(FoodAllergyDto foodAllergyDto);
    List<FoodAllergyDto> addFoodAllergies(List<FoodAllergyDto> foodAllergyDtoList);
}
