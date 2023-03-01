package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table
@NamedQueries(value = { @NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o ORDER BY o.name ASC"),
        @NamedQuery(name = "Occupation.findById", query = "SELECT o FROM Occupation o WHERE o.id = :id") })
public class Occupation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Transient
    private String prefix;

    private String name;
    private String description;

    @Version
    private int version;
}