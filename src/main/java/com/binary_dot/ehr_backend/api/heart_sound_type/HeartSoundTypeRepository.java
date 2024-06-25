package com.binary_dot.ehr_backend.api.heart_sound_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartSoundTypeRepository extends JpaRepository<HeartSoundType, Integer> {
    List<HeartSoundType> findByName(String name);
}
