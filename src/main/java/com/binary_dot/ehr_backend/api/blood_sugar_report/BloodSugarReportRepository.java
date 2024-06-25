package com.binary_dot.ehr_backend.api.blood_sugar_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodSugarReportRepository extends JpaRepository<BloodSugarReport, Integer> {

}

