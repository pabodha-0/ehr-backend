package com.binary_dot.ehr_backend.api.examination_report;

import com.binary_dot.ehr_backend.api.abdomen_infection_type.AbdomenInfectionTypeDto;
import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.ear_infection_type.EarInfectionTypeDto;
import com.binary_dot.ehr_backend.api.heart_rhythm_type.HeartRhythmTypeDto;
import com.binary_dot.ehr_backend.api.heart_sound_type.HeartSoundTypeDto;
import com.binary_dot.ehr_backend.api.lungs_infection_type.LungsInfectionTypeDto;
import com.binary_dot.ehr_backend.api.lymph_node_infection_type.LymphNodeInfectionTypeDto;
import com.binary_dot.ehr_backend.api.nose_infection_type.NoseInfectionTypeDto;
import com.binary_dot.ehr_backend.api.throat_infection_type.ThroatInfectionTypeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationReportDto {
    private int id;

    private boolean pale;

    private float temperature;

    private AppointmentDto appointment;

    @JsonIgnoreProperties("examinationReports")
    private EarInfectionTypeDto earInfectionType;

    @JsonIgnoreProperties("examinationReports")
    private NoseInfectionTypeDto noseInfectionType;

    @JsonIgnoreProperties("examinationReports")
    private ThroatInfectionTypeDto throatInfectionType;

    @JsonIgnoreProperties("examinationReports")
    private AbdomenInfectionTypeDto abdomenInfectionType;

    @JsonIgnoreProperties("examinationReports")
    private LymphNodeInfectionTypeDto lymphNodeInfectionType;

    @JsonIgnoreProperties("examinationReports")
    private LungsInfectionTypeDto lungsInfectionType;

    @JsonIgnoreProperties("examinationReports")
    private HeartSoundTypeDto heartSoundType;

    @JsonIgnoreProperties("examinationReports")
    private HeartRhythmTypeDto heartRhythmType;

    private int pulse;

    private String firstBloodPressure;

    private String secondBloodPressure;

    private String leftEye;

    private String rightEye;
}
