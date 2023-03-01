package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.PAEBUILDINGCLASS)
public class PAEBuildingClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private int fromAge;
	private int toAge;
	private float paeRate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BUILDINGCLASSID", referencedColumnName = "ID")
	private BuildingClass buildingClass;

	@Embedded
	private UserRecorder recorder;

	@Version
	private int version;
}
