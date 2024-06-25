package com.binary_dot.ehr_backend.api.food_allergy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodAllergyMapper {
    @Autowired
    private ModelMapper modelMapper;

    public FoodAllergyDto mapToDto(FoodAllergy foodAllergy) {
        return modelMapper.map(foodAllergy, FoodAllergyDto.class);
    }

    public FoodAllergy mapToEntity(FoodAllergyDto foodAllergyDto) {
        return modelMapper.map(foodAllergyDto, FoodAllergy.class);
    }
}
