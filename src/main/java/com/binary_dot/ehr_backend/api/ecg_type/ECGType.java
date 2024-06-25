package com.binary_dot.ehr_backend.api.ecg_type;

import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReport;
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
@Table(name = "ecg_type")
public class ECGType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "ecgType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OtherTestReport> otherTestReports;

    private String name;
}
