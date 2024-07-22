package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import com.binary_dot.ehr_backend.api.drug_info.DrugInfo;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequency;
import com.binary_dot.ehr_backend.api.treatment.Treatment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "treatment_drug_internal")
public class TreatmentDrugInternal {
    @EmbeddedId
    TreatmentDrugInternalId id;

    @ManyToOne
    @MapsId("treatmentId")
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    @ManyToOne
    @MapsId("drugInfoId")
    @JoinColumn(name = "drug_info_id")
    private DrugInfo drugInfo;

    @ManyToOne()
    @JoinColumn(name = "drug_intake_frequency_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DrugIntakeFrequency drugIntakeFrequency;
}
