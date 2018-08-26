package com.libertyglobal.PotatoMarket.enumerations;

/**
 * Enumeration Supplier mentioning the allowed Supplier for Potato Bags. 
 * 
 * @author Rabindra Rakshit
 */

public enum Supplier {
	SUPPLIER_ONE("De Coster"),
	SUPPLIER_TWO("Owel"),
	SUPPLIER_THREE("Patatas Ruben"),
	SUPPLIER_FOUR("Yunnan Spices");

    private final String text;

    Supplier(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
