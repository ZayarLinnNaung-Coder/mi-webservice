package org.ace.insurance.productservice.model;

public enum KeyFactorType {
    REFERENCE("Reference"), FROM_TO("From-To"), FIXED("Fixed"), ENUM("Enum"), BOOLEAN("Boolean");

    private String label;

    private KeyFactorType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
