package org.ace.insurance.utilityservice.enumeration;

public enum StampFeeRateType {

    FIXED("Fixed"), BASEDONSI("Based On SI"), BASEONUNIT("Based On Unit");

    private String label;

    private StampFeeRateType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
