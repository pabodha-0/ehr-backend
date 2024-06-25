package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.api.blood_report.BloodReportDto;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisDto;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportDto;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportDto;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileDto;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportDto;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportDto;
import com.binary_dot.ehr_backend.api.patient.PatientDto;
import com.binary_dot.ehr_backend.api.symptom.SymptomDto;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportDto;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private int id;

    @JsonIgnoreProperties("appointments")
    private PatientDto patient;

    @JsonIgnoreProperties("appointments")
    private List<SymptomDto> symptoms;

    private ExaminationReportDto examinationReport;

    private BloodReportDto bloodReport;

    private BloodSugarReportDto bloodSugarReport;

    private KidneyReportDto kidneyReport;

    private LipidProfileDto lipidProfile;

    private LiverReportDto liverReport;

    private OtherTestReportDto otherTestReport;

    private ThyroidReportDto thyroidReport;

    private UrineReportDto urineReport;

    @JsonIgnoreProperties("appointments")
    private List<DiagnosisDto> diagnoses;
}
