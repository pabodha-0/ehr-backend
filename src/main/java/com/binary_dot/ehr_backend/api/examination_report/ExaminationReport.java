package com.binary_dot.ehr_backend.api.examination_report;

import com.binary_dot.ehr_backend.api.abdomen_infection_type.AbdomenInfectionType;
import com.binary_dot.ehr_backend.api.appointment.Appointment;
import com.binary_dot.ehr_backend.api.ear_infection_type.EarInfectionType;
import com.binary_dot.ehr_backend.api.heart_rhythm_type.HeartRhythmType;
import com.binary_dot.ehr_backend.api.heart_sound_type.HeartSoundType;
import com.binary_dot.ehr_backend.api.lungs_infection_type.LungsInfectionType;
import com.binary_dot.ehr_backend.api.lymph_node_infection_type.LymphNodeInfectionType;
import com.binary_dot.ehr_backend.api.nose_infection_type.NoseInfectionType;
import com.binary_dot.ehr_backend.api.throat_infection_type.ThroatInfectionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "examination_report")
public class ExaminationReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private boolean pale;

    private float temperature;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "examinationReport")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name="ear_infection_type_id")
    private EarInfectionType earInfectionType;

    @ManyToOne
    @JoinColumn(name="nose_infection_type_id")
    private NoseInfectionType noseInfectionType;

    @ManyToOne
    @JoinColumn(name="throat_infection_type_id")
    private ThroatInfectionType throatInfectionType;

    @ManyToOne
    @JoinColumn(name="abdomen_infection_type_id")
    private AbdomenInfectionType abdomenInfectionType;

    @ManyToOne
    @JoinColumn(name="lymph_node_infection_type_id")
    private LymphNodeInfectionType lymphNodeInfectionType;

    @ManyToOne
    @JoinColumn(name="lungs_infection_type_id")
    private LungsInfectionType lungsInfectionType;

    @ManyToOne
    @JoinColumn(name="heart_sound_type_id")
    private HeartSoundType heartSoundType;

    @ManyToOne
    @JoinColumn(name="heart_rhythm_type_id")
    private HeartRhythmType heartRhythmType;

    private int pulse;

    @Column(name = "first_blood_pressure")
    private String firstBloodPressure;

    @Column(name = "second_blood_pressure")
    private String secondBloodPressure;

    @Column(name = "left_eye")
    private String leftEye;

    @Column(name = "right_eye")
    private String rightEye;
}
