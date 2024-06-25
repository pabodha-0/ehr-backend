package com.binary_dot.ehr_backend.api.food_allergy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodAllergyRepository extends JpaRepository<FoodAllergy, Integer> {
    List<FoodAllergy> findByName(String name);
}
