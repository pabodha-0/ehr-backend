package com.binary_dot.ehr_backend.api.appointment_symptom;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSymptomId implements Serializable {
    @Column(name = "appointment_id")
    private int appointmentId;

    @Column(name = "symptom_id")
    private int symptomId;
}
