package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.api.blood_report.BloodReport;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReport;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReport;
import com.binary_dot.ehr_backend.api.symptom.Symptom;
import com.binary_dot.ehr_backend.api.urine_report.UrineReport;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReport;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReport;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfile;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReport;
import com.binary_dot.ehr_backend.api.liver_report.LiverReport;
import com.binary_dot.ehr_backend.api.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

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

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "appointment_symptom", inverseJoinColumns = @JoinColumn(name = "symptom_id"))
    List<Symptom> symptoms;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "examination_report_id")
    private ExaminationReport examinationReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "blood_report_id")
    private BloodReport bloodReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "blood_sugar_report_id")
    private BloodSugarReport bloodSugarReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "kidney_report_id")
    private KidneyReport kidneyReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "lipid_profile_id")
    private LipidProfile lipidProfile;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "liver_report_id")
    private LiverReport liverReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "other_test_report_id")
    private OtherTestReport otherTestReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "thyroid_report_id")
    private ThyroidReport thyroidReport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "urine_report_id")
    private UrineReport urineReport;

//    @ManyToMany()
//    @JoinTable(name = "appointment_diagnosis", inverseJoinColumns = @JoinColumn(name = "diagnosis_id"))
//    List<Diagnosis> diagnoses;
}
