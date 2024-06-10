package com.binary_dot.ehr_backend.entity;

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
    private int temperature;

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
    private int firstBloodPressure;

    @Column(name = "second_blood_pressure")
    private int secondBloodPressure;

    @Column(name = "left_eye")
    private int leftEye;

    @Column(name = "right_eye")
    private int rightEye;
}
