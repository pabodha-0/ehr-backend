package com.binary_dot.ehr_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medical_history_id", nullable = false)
    private MedicalHistory medicalHistory;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "social_history_id", nullable = false)
    private SocialHistory socialHistory;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "surgical_history_id", nullable = false)
    private SurgicalHistory surgicalHistory;

    @ManyToMany()
    @JoinTable(name = "patient_food_allergy", inverseJoinColumns = @JoinColumn(name = "food_allergy_id"))
    Set<FoodAllergy> foodAllergies;

    @ManyToMany()
    @JoinTable(name = "patient_drug_allergy", inverseJoinColumns = @JoinColumn(name = "drug_allergy_id"))
    Set<DrugAllergy> drugAllergies;

    private String name;

    private String gender;

    private int dob;

    private String address;

    private String phone;
}
