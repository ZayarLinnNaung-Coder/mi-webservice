package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.ROOF)
@NamedQueries(value = {@NamedQuery(name = "Roof.findAll", query = "SELECT r FROM Roof r ORDER BY r.name ASC"),
        @NamedQuery(name = "Roof.findById", query = "SELECT r FROM Roof r WHERE r.id = :id")})

public class Roof implements Serializable {
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