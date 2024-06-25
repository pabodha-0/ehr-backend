package com.binary_dot.ehr_backend.api.drug_intake_frequency;

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
@Table(name = "drug_intake_frequency")
public class DrugIntakeFrequency {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "times_per_day")
    private int timesPerDay;
}
