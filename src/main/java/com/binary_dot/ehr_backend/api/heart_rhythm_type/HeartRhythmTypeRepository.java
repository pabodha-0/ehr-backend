package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRhythmTypeRepository extends JpaRepository<HeartRhythmType, Integer> {
    List<HeartRhythmType> findByName(String name);
}
