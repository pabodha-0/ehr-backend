package com.binary_dot.ehr_backend.api.symptom;

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
@Table(name = "symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "symptoms", cascade = CascadeType.MERGE)
    List<Appointment> appointments;

    private String name;
}
