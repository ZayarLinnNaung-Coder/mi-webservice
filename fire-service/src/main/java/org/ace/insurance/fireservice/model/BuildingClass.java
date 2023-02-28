package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.BUILDINGCLASS)
public class BuildingClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Transient
	private String prefix;
	private String name;
	private int distance;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buildingClass", orphanRemoval = true)
	private List<ClassValue> classValueList;

	@Version
	private int version;

	public void addClassValue(ClassValue classValue) {
		if (classValueList == null) {
			classValueList = new ArrayList<>();
		}
		classValue.setBuildingClass(this);
		classValueList.add(classValue);
	}
}