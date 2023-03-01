package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String insuranceType;
    @Version
    private int version;

    @Embedded
    private CommonCreateAndUpateMarks commonCreateAndUpateMarks;
}

