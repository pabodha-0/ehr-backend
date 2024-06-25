package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

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
@Table(name = "lymph_node_infection_type")
public class LymphNodeInfectionType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "lymphNodeInfectionType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExaminationReport> examinationReports;

    private String name;
}
