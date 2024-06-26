package com.binary_dot.ehr_backend.api.patient;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
import com.binary_dot.ehr_backend.api.drug_allergy.DrugAllergy;
import com.binary_dot.ehr_backend.api.food_allergy.FoodAllergy;
import com.binary_dot.ehr_backend.api.medical_history.MedicalHistory;
import com.binary_dot.ehr_backend.api.patient_relation.PatientRelation;
import com.binary_dot.ehr_backend.api.social_history.SocialHistory;
import com.binary_dot.ehr_backend.api.surgical_history.SurgicalHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;

    private String gender;

    private int dob;

    private String address;

    private String phone;

    private String occupation;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Appointment> appointments;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_history_id")
    private MedicalHistory medicalHistory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_history_id")
    private SocialHistory socialHistory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surgical_history_id")
    private SurgicalHistory surgicalHistory;

    @ManyToMany()
    @JoinTable(name = "patient_food_allergy", inverseJoinColumns = @JoinColumn(name = "food_allergy_id"))
    private List<FoodAllergy> foodAllergies;

    @ManyToMany()
    @JoinTable(name = "patient_drug_allergy", inverseJoinColumns = @JoinColumn(name = "drug_allergy_id"))
    private List<DrugAllergy> drugAllergies;

//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PatientRelation> relations;

    @OneToMany(mappedBy = "relatedPatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatientRelation> relations;
}
