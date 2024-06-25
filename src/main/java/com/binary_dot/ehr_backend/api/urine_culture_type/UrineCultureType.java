package com.binary_dot.ehr_backend.api.urine_culture_type;

import com.binary_dot.ehr_backend.api.urine_report.UrineReport;
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
@Table(name = "urine_culture_type")
public class UrineCultureType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "urineCultureType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UrineReport> urineReports;

    private String name;
}
