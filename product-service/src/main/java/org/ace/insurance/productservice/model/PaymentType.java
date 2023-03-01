package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableName.PAYMENTTYPE)
@NamedQueries(value = { @NamedQuery(name = "PaymentType.findAll", query = "SELECT p FROM PaymentType p ORDER BY p.name ASC"),
        @NamedQuery(name = "PaymentType.findByName", query = "SELECT p FROM PaymentType p WHERE p.name=:name"),
        @NamedQuery(name = "PaymentType.findById", query = "SELECT p FROM PaymentType p WHERE p.id = :id") })
public class PaymentType implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;

        @Transient
        private String prefix;

        private String name;
        private String description;
        private int month;

        @Version
        private int version;


}
