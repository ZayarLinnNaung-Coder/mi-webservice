package org.ace.insurance.utilityservice.enumeration;

public enum InsuranceType {

    LIFE("LIFE"),

    HEALTH("Health"),

    FIRE("FIRE"),

    MOTOR("MOTOR"),

    CASH_IN_SAFE("CASH_IN_SAFE"),

    MEDICAL("MEDICAL"),

    CASHIN_TRANSIT("CASHIN_TRANSIT"),

    TRAVEL_INSURANCE("TRAVEL_INSURANCE"),

    FIDELITY("FIDELITY"),

    CARGO("CARGO"),

    OVERSEASCARGO("Overseas Cargo"),

    MARINEHULL("Marine Hull"),

    PERSON_TRAVEL("PERSON_TRAVEL"),

    PERSONAL_ACCIDENT("PERSONAL_ACCIDENT"),

    SPORTMANABROAD("Sport Man Abroad"),

    FARMER("Farmer"),

    THIRDPARTY("Third Party"),

    MOTORCYCLETYPE("Motorcycle Type"),

    SEAMEN("SEAMEN LIFE ASSURANCE"),

    DRIVERTYPE("Driver Type");

    private String label;

    private InsuranceType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
