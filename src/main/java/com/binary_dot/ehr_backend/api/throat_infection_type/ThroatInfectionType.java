package com.binary_dot.ehr_backend.api.throat_infection_type;

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
@Table(name = "throat_infection_type")
public class ThroatInfectionType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "throatInfectionType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExaminationReport> examinationReports;

    private String name;
}
