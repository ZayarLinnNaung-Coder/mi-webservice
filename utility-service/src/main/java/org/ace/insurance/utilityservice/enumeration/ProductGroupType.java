package org.ace.insurance.utilityservice.enumeration;

public enum ProductGroupType {
	LIFE("LIFE"), 
	NONLIFE("NONLIFE"), 
	COMPOSITE("COMPOSITE");

	private String label;

	private ProductGroupType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
