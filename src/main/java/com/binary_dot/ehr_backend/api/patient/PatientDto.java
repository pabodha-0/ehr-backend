package com.binary_dot.ehr_backend.api.patient;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.drug_allergy.DrugAllergyDto;
import com.binary_dot.ehr_backend.api.medical_history.MedicalHistoryDto;
import com.binary_dot.ehr_backend.api.patient_relation.PatientRelation;
import com.binary_dot.ehr_backend.api.patient_relation.PatientRelationDto;
import com.binary_dot.ehr_backend.api.social_history.SocialHistoryDto;
import com.binary_dot.ehr_backend.api.surgical_history.SurgicalHistoryDto;
import com.binary_dot.ehr_backend.api.food_allergy.FoodAllergyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PatientDto {
    private int id;

    private String name;

    private String gender;

    private int dob;

    private String address;

    private String phone;

    private String occupation;

    @JsonIgnoreProperties("patient")
    private List<AppointmentDto> appointments;

    @JsonIgnoreProperties("patient")
    private MedicalHistoryDto medicalHistory;

    @JsonIgnoreProperties("patient")
    private SocialHistoryDto socialHistory;

    @JsonIgnoreProperties("patient")
    private SurgicalHistoryDto surgicalHistory;

    @JsonIgnoreProperties("patients")
    private List<FoodAllergyDto> foodAllergies;

    @JsonIgnoreProperties("patients")
    private List<DrugAllergyDto> drugAllergies;

//    @JsonIgnoreProperties("fromPatient")
//    private List<PatientRelationDto> fromPatientRelations;

//    @JsonIgnore
    private List<PatientRelationDto> relations;
}
