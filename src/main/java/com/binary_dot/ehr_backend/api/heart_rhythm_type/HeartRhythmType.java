package com.binary_dot.ehr_backend.api.heart_rhythm_type;

import com.binary_dot.ehr_backend.api.examination_report.ExaminationReport;
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
@Table(name = "heart_rhythm_type")
public class HeartRhythmType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "heartRhythmType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExaminationReport> examinationReports;

    private String name;
}
