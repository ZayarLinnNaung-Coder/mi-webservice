package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.CLASSVALUE)
@NamedQueries(value = { @NamedQuery(name = "ClassValue.findAll", query = "SELECT c FROM ClassValue c "),
		@NamedQuery(name = "ClassValue.findById", query = "SELECT c FROM ClassValue c WHERE c.id = :id") })

public class ClassValue implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Transient
	private String prefix;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROOFID", referencedColumnName = "ID")
	private Roof roof;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WALLID", referencedColumnName = "ID")
	private Wall wall;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FLOORID", referencedColumnName = "ID")
	private Floor floor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDINGCLASSID", referencedColumnName = "ID")
	private BuildingClass buildingClass;

	@Version
	private int version;

	public ClassValue(Roof roof, Wall wall, Floor floor) {
		this.roof = roof;
		this.wall = wall;
		this.floor = floor;
	}

}