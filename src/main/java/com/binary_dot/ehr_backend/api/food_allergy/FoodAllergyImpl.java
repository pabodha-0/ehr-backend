package com.binary_dot.ehr_backend.api.food_allergy;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodAllergyImpl implements FoodAllergyService{
    @Autowired
    FoodAllergyRepository foodAllergyRepository;

    @Autowired
    FoodAllergyMapper foodAllergyMapper;

    @Override
    public FoodAllergyDto addFoodAllergy(FoodAllergyDto foodAllergyDto) {
        List<FoodAllergy> existingFoodAllergies = foodAllergyRepository.findByName(foodAllergyDto.getName());
        if(existingFoodAllergies.isEmpty()){
            FoodAllergy foodAllergy = foodAllergyRepository.save(foodAllergyMapper.mapToEntity(foodAllergyDto));
            return foodAllergyMapper.mapToDto(foodAllergy);
        }

        return foodAllergyMapper.mapToDto(existingFoodAllergies.getFirst());
    }

    @Override
    public List<FoodAllergyDto> addFoodAllergies(List<FoodAllergyDto> foodAllergyDtoList) {
        if(foodAllergyDtoList == null || foodAllergyDtoList.isEmpty()){
            return new ArrayList<>();
        }

        List<FoodAllergyDto> foodAllergies = new ArrayList<>();
        for (FoodAllergyDto foodAllergyDto : foodAllergyDtoList) {
            foodAllergies.add(addFoodAllergy(foodAllergyDto));
        }

        return foodAllergies;
    }

    @Override
    public FoodAllergyDto findById(int id) throws NotFoundException {
        FoodAllergy foodAllergy = foodAllergyRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Food Allergy not found by id: " + id)
        );
        return foodAllergyMapper.mapToDto(foodAllergy);
    }

    @Override
    public List<FoodAllergyDto> findAll() {
        List<FoodAllergy> foodAllergies = foodAllergyRepository.findAll();
        return foodAllergies.stream().map(allergy -> foodAllergyMapper.mapToDto(allergy)).toList();
    }


}
