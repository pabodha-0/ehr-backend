package com.binary_dot.ehr_backend.api.heart_sound_type;

import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeartSoundTypeDto {
    private int id;

    private String name;

    @JsonIgnore
    private List<ExaminationReportDto> examinationReports;
}
