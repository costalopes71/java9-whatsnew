package com.java9whatsnew.small_language_changes;

public interface PrivateMethodsOnInterfaces {

	double getPrice();
	
	default double getPriceWithTax() {
		return getTaxedPriceInternal();
	}

	default double getOfferPrice(double discount) {
		return getTaxedPriceInternal() * discount;
	}
	
	private double getTaxedPriceInternal() {
		return getPrice() * 1.21;
	}
	
}