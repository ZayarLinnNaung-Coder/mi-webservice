package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;
import org.ace.insurance.utilityservice.enumeration.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.PRODUCT)
@NamedQueries(value = { @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p ORDER by p.productContent.name ASC"),
        @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.findByInsuranceType", query = "SELECT p FROM Product p WHERE p.insuranceType = :insuranceType"),
        @NamedQuery(name = "Product.findProductByCurrencyType", query = "SELECT p FROM Product p WHERE p.insuranceType = :insuranceType AND p.currency = :currency ") })
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int maxTerm;
    private int minTerm;
    private int standardExcess;
    private int maxAge;
    private int minAge;
    private int maxHospDays;

    @Column(name = "MAXIMUMVALUE")
    private double maxValue;
    @Column(name = "MINIMUMVALUE")
    private double minValue;
    private double basedAmount;
    private float firstCommission;
    private float renewalCommission;
    private boolean isBaseOnKeyFactor;
    private String multiCurPrefix;
    private double stampFee;
    private double stampFeeBasedAmount;
    private double sumInsuredPerUnit;

    @Enumerated(EnumType.STRING)
    private PremiumRateType premiumRateType;

    @Enumerated(EnumType.STRING)
    private StampFeeRateType stampFeeRateType;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Enumerated(EnumType.STRING)
    private ProductBaseType productBaseType;

    @Enumerated(EnumType.STRING)
    private PeriodType maxTermType;

    @Enumerated(EnumType.STRING)
    private PeriodType minTermType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTCONTENTID", referencedColumnName = "ID")
    private ProductContent productContent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTGROUPID", referencedColumnName = "ID")
    private ProductGroup productGroup;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_PAYMENTTYPE_LINK", joinColumns = { @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "PAYMENTTYPEID", referencedColumnName = "ID") })
    private List<PaymentType> paymentTypeList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID")
    private List<AddOn> addOnList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_KEYFACTOR_LINK", joinColumns = { @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "KEYFACTORID", referencedColumnName = "ID") })
    private List<KeyFactor> keyFactorList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCYID", referencedColumnName = "ID")
    private Currency currency;

    @Embedded
    private UserRecorder recorder;

    @Version
    private int version;

    public List<AddOn> getAddOnList() {
        if (addOnList == null) {
            addOnList = new ArrayList<>();
        }
        return addOnList;
    }

    public List<KeyFactor> getKeyFactorList() {
        if (keyFactorList == null) {
            keyFactorList = new ArrayList<KeyFactor>();
        }
        return keyFactorList;
    }

    public String getName() {
        String name = "";
        if (productContent != null) {
            name = productContent.getName();
        }
        return name;
    }

    public List<AddOn> getSortedAddOnList() {
        Collections.sort(getAddOnList(), new Comparator<AddOn>() {
            public int compare(AddOn o1, AddOn o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return addOnList;
    }
}
