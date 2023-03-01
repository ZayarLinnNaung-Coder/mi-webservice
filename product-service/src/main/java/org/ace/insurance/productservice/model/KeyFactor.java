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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.KEYFACTOR)
@NamedQueries(value = { @NamedQuery(name = "KeyFactor.findAll", query = "SELECT k FROM KeyFactor k ORDER BY k.value ASC"),
        @NamedQuery(name = "KeyFactor.findById", query = "SELECT k FROM KeyFactor k WHERE k.id = :id") })
public class KeyFactor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String value;
    @Enumerated(value = EnumType.STRING)
    private KeyFactorType keyFactorType;
    @Version
    private int version;
    @Embedded
    private UserRecorder recorder;

    public KeyFactor(KeyFactor keyFactor) {
        this.id = keyFactor.getId();
        this.value = keyFactor.getValue();
        this.keyFactorType = keyFactor.getKeyFactorType();
        this.recorder = keyFactor.getRecorder();
        this.version = keyFactor.getVersion();
    }

    public String getEnumValue() {
        return value.substring(value.lastIndexOf(".") + 1);
    }
}
