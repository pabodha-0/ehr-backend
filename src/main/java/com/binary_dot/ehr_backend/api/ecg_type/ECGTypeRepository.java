package com.binary_dot.ehr_backend.api.ecg_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ECGTypeRepository extends JpaRepository<ECGType, Integer> {
    List<ECGType> findByName(String name);
}
