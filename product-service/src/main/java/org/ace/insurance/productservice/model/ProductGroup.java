package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.embeddable.NcbRate;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;
import org.ace.insurance.utilityservice.enumeration.NcbYear;
import org.ace.insurance.utilityservice.enumeration.ProductGroupType;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.PRODUCTGROUP)
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private String policyNoPrefix;
    private String proposalNoPrefix;
    private double fleetDiscount;
    private double underSession13;
    private double underSession25;
    private double maxSumInsured;

    @Column(name = "ACCOUNTNAME")
    private String accountCode;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "GROUPTYPE")
    private ProductGroupType groupType;

    @ElementCollection
    @CollectionTable(name = "PRODUCTGROUP_NCBRATE_LINK", joinColumns = @JoinColumn(name = "PRODUCTGROUPID", referencedColumnName = "ID"))
    private List<NcbRate> ncbRates;
    @Embedded
    private UserRecorder recorder;
    @Version
    private int version;

    public float getNCBPercentage(NcbYear ncbYear) {
        float percentage = 0.0f;
        if (ncbRates != null && !ncbRates.isEmpty()) {
            switch (ncbYear) {
                case FIRST_YEAR: {
                    for (NcbRate rate : ncbRates) {
                        if (NcbYear.FIRST_YEAR.equals(rate.getNcbYear())) {
                            percentage = rate.getNcbPercentage();
                        }
                    }
                }
                break;
                case SECOND_YEAR: {
                    for (NcbRate rate : ncbRates) {
                        if (NcbYear.SECOND_YEAR.equals(rate.getNcbYear())) {
                            percentage = rate.getNcbPercentage();
                        }
                    }
                }
                break;
                case THIRD_YEAR: {
                    for (NcbRate rate : ncbRates) {
                        if (NcbYear.THIRD_YEAR.equals(rate.getNcbYear())) {
                            percentage = rate.getNcbPercentage();
                        }
                    }
                }
                break;
                case ABOVE_THIRD_YEAR: {
                    for (NcbRate rate : ncbRates) {
                        if (NcbYear.ABOVE_THIRD_YEAR.equals(rate.getNcbYear())) {
                            percentage = rate.getNcbPercentage();
                        }
                    }
                }
                break;
                case FIXED: {
                    for (NcbRate rate : ncbRates) {
                        if (NcbYear.FIXED.equals(rate.getNcbYear())) {
                            percentage = rate.getNcbPercentage();
                        }
                    }
                }
                break;
            }
        }
        return percentage;
    }
}
