package com.binary_dot.ehr_backend.api.diagnosis;

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
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

//    @ManyToMany(mappedBy = "diagnoses")
//    Set<Appointment> appointments;

    private String name;
}
