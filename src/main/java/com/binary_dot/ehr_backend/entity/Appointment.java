package com.binary_dot.ehr_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

    @ManyToMany()
    @JoinTable(name = "appointment_symptom", inverseJoinColumns = @JoinColumn(name = "symptom_id"))
    Set<Symptom> symptoms;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "blood_report_id", nullable = false)
    private BloodReport bloodReport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blood_sugar_report_id", nullable = false)
    private BloodSugarReport bloodSugarReport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kidney_report_id", nullable = false)
    private KidneyReport kidneyReport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lipid_profile_id", nullable = false)
    private LipidProfile lipidProfile;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "liver_report_id", nullable = false)
    private LiverReport liverReport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "other_test_report_id", nullable = false)
    private OtherTestReport otherTestReport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "thyroid_report_id", nullable = false)
    private ThyroidReport thyroidReport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "urine_report_id", nullable = false)
    private UrineReport urineReport;

    @ManyToMany()
    @JoinTable(name = "appointment_diagnosis", inverseJoinColumns = @JoinColumn(name = "diagnosis_id"))
    Set<Diagnosis> diagnoses;
}
