package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.BUILDINGOCCUPATION)
public class BuildingOccupation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Transient
    private String prefix;

    private String name;
    private String buildingOccupationType;
    private String description;

    @Version
    private int version;
}