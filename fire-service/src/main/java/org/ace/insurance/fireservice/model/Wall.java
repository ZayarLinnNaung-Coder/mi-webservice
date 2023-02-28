package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.WALL)
@NamedQueries(value = { @NamedQuery(name = "Wall.findAll", query = "SELECT w FROM Wall w ORDER BY w.name ASC"),
		@NamedQuery(name = "Wall.findById", query = "SELECT w FROM Wall w WHERE w.id = :id") })
public class Wall implements Serializable {
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