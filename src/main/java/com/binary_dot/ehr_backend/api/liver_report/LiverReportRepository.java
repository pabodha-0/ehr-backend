package com.binary_dot.ehr_backend.api.liver_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiverReportRepository extends JpaRepository<LiverReport, Integer> {

}
