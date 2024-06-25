package com.binary_dot.ehr_backend.api.urine_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrineReportRepository extends JpaRepository<UrineReport, Integer> {

}
