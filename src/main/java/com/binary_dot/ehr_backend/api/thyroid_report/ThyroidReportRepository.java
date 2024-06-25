package com.binary_dot.ehr_backend.api.thyroid_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThyroidReportRepository extends JpaRepository<ThyroidReport, Integer> {

}