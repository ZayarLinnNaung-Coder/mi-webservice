package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.enumeration.InsuranceType;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.ROUTE)
@NamedQueries(value = { @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r "),
        @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id") })
public class Route implements Serializable {
    private static final long serialVersionUID = -5051498836613520404L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Embedded
    private CommonCreateAndUpateMarks commonCreateAndUpateMarks;

    @Version
    private int version;

    public Route(String id, String name, String description, InsuranceType insuranceType, int version) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.insuranceType = insuranceType;
    }
}
