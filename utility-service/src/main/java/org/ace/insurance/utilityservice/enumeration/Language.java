package org.ace.insurance.utilityservice.enumeration;

public enum Language {

    ENGLISH("English"), MYANMAR("Myanmar");

    private String label;

    private Language(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
