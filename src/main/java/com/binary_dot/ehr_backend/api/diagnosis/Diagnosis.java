package com.binary_dot.ehr_backend.api.diagnosis;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
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
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "diagnoses")
    List<Appointment> appointments;

    private String name;
}
