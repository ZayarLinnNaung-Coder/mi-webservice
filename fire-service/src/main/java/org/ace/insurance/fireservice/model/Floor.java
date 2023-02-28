package org.ace.insurance.fireservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = TableName.FLOOR)
public class Floor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Transient
	private String prefix;
	private String name;
	private String description;

	@Version
	private int version;

	public Floor(String id, String name) {
		this.id = id;
		this.name = name;
	}

}