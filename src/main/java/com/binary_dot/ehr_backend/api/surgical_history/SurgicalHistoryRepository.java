package com.binary_dot.ehr_backend.api.surgical_history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgicalHistoryRepository extends JpaRepository<SurgicalHistory, Integer> {

}
