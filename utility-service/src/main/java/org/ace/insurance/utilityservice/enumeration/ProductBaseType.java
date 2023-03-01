package org.ace.insurance.utilityservice.enumeration;

public enum ProductBaseType {
     SI("SI"), UNIT("Unit");

    private String label;

    private ProductBaseType(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
