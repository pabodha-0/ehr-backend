package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.api.appointment_symptom.AppointmentSymptomDto;
import com.binary_dot.ehr_backend.api.blood_report.BloodReportDto;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisDto;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportDto;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportDto;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileDto;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportDto;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportDto;
import com.binary_dot.ehr_backend.api.patient.PatientDto;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportDto;
import com.binary_dot.ehr_backend.api.treatment_drug_external.TreatmentDrugExternalDto;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalDto;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private int id;

    @JsonIgnoreProperties("appointments")
    private PatientDto patient;

    private int price;

    @JsonIgnoreProperties("appointment")
    private List<AppointmentSymptomDto> appointmentSymptoms;

    @JsonIgnoreProperties("appointment")
    private ExaminationReportDto examinationReport;

    @JsonIgnoreProperties("appointment")
    private BloodReportDto bloodReport;

    @JsonIgnoreProperties("appointment")
    private BloodSugarReportDto bloodSugarReport;

    @JsonIgnoreProperties("appointment")
    private KidneyReportDto kidneyReport;

    @JsonIgnoreProperties("appointment")
    private LipidProfileDto lipidProfile;

    @JsonIgnoreProperties("appointment")
    private LiverReportDto liverReport;

    @JsonIgnoreProperties("appointment")
    private OtherTestReportDto otherTestReport;

    @JsonIgnoreProperties("appointment")
    private ThyroidReportDto thyroidReport;

    @JsonIgnoreProperties("appointment")
    private UrineReportDto urineReport;

    @JsonIgnoreProperties("appointment")
    private List<TreatmentDrugInternalDto> treatmentDrugInternalList;

    @JsonIgnoreProperties("appointment")
    private List<TreatmentDrugExternalDto> treatmentDrugExternalList;

    @JsonIgnoreProperties("appointments")
    private List<DiagnosisDto> diagnoses;

    private Instant createdOn;

    private Instant lastUpdatedOn;
}
