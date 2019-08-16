package com.billing.discount.constant;

/**
 * 
 * @author Rahul
 *
 */
public enum CustomerType {

	EMPLOYEE(30), AFFILIATE(10), CUSTOMER(5);

	private double discountPercentage;

	CustomerType(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

}