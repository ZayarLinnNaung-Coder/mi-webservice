package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;
import org.ace.insurance.utilityservice.enumeration.PremiumRateType;
import org.ace.insurance.utilityservice.enumeration.ProductBaseType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.ADDON)
@NamedQueries(value = { @NamedQuery(name = "AddOn.findAll", query = "SELECT a FROM AddOn a ORDER BY a.id ASC"),
        @NamedQuery(name = "AddOn.findById", query = "SELECT a FROM AddOn a WHERE a.id = :id") })
public class AddOn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "MAXIMUMVALUE")
    private double maxValue;
    @Column(name = "MINIMUMVALUE")
    private double minValue;
    private boolean isBaseOnKeyFactor;
    private boolean isCompulsory;
    private double basedAmount;
    private double sumInsuredPerUnit;

    @Enumerated(EnumType.STRING)
    private PremiumRateType premiumRateType;

    @Enumerated(EnumType.STRING)
    private ProductBaseType productBaseType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTCONTENTID", referencedColumnName = "ID")
    private ProductContent productContent;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ADDON_KEYFACTOR_LINK", joinColumns = { @JoinColumn(name = "ADDONID", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "KEYFACTORID", referencedColumnName = "ID") })
    private List<KeyFactor> keyFactorList;
    @Version
    private int version;

    @Embedded
    private UserRecorder recorder;

    @Transient
    private boolean include;

    public AddOn(AddOn addOn) {
        this.id = addOn.getId();
        this.maxValue = addOn.getMaxValue();
        this.minValue = addOn.getMinValue();
        this.isBaseOnKeyFactor = addOn.isBaseOnKeyFactor();
        this.isCompulsory = addOn.isCompulsory();
        this.basedAmount = addOn.getBasedAmount();
        this.sumInsuredPerUnit = addOn.getSumInsuredPerUnit();
        this.premiumRateType = addOn.getPremiumRateType();
        this.productBaseType = addOn.getProductBaseType();
        this.productContent = addOn.getProductContent();
        this.recorder = addOn.getRecorder();
        this.version = addOn.getVersion();
        for (KeyFactor kf : addOn.getKeyFactorList()) {
            getKeyFactorList().add(new KeyFactor(kf));
        }
    }

    public AddOn(AddOn addOn, double premiumRate) {
        this.id = addOn.getId();
        this.maxValue = addOn.getMaxValue();
        this.minValue = addOn.getMinValue();
        this.isBaseOnKeyFactor = addOn.isBaseOnKeyFactor();
        this.isCompulsory = addOn.isCompulsory();
        this.basedAmount = addOn.getBasedAmount();
        this.premiumRateType = addOn.getPremiumRateType();
        this.productBaseType = addOn.getProductBaseType();
        this.productContent = addOn.getProductContent();
    }
    public List<KeyFactor> getKeyFactorList() {
        if (keyFactorList == null) {
            keyFactorList = new ArrayList<>();
        }
        return keyFactorList;
    }

    public String getName() {
        String result = "";
        if (productContent != null) {
            result = productContent.getName();
        }
        return result;
    }

    public String getCode() {
        String result = "";
        if (productContent != null) {
            result = productContent.getCode();
        }
        return result;
    }

    public boolean isNeedInputType() {
        boolean result = false;
        if (PremiumRateType.BASED_ON_OWN_SUMINSURED.equals(premiumRateType)) {
            result = true;
        } else if (PremiumRateType.PER_UNIT.equals(premiumRateType)) {
            result = true;
        }
        return result;
    }


}
