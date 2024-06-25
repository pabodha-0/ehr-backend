package com.binary_dot.ehr_backend.api.blood_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodReportRepository extends JpaRepository<BloodReport, Integer> {

}
