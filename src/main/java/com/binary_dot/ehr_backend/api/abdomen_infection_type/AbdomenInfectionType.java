package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.api.examination_report.ExaminationReport;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "abdomen_infection_type")
public class AbdomenInfectionType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "abdomenInfectionType", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<ExaminationReport> examinationReports;

    private String name;
}
