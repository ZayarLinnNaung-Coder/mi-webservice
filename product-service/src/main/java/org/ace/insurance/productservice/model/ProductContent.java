package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableName.PRODUCTCONTENT)
public class ProductContent implements Serializable {

    private static final long serialVersionUID = 2253619645955447054L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private String code;

    @Embedded
    private UserRecorder recorder;

    @Version
    private int version;

    public ProductContent(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
