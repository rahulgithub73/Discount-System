package com.billing.discount.entity;

import java.time.LocalDate;

import com.billing.discount.constant.CustomerType;

/**
 * 
 * @author Rahul
 *
 */
public class Customer {

	private String customerID;

	private String customerName;

	private String customerEmail;

	private LocalDate enrollmentDate;

	private CustomerType customerType;

	public Customer(String customerID, String customerName, String customerEmail, LocalDate enrollmentDate,
			CustomerType customerType) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.enrollmentDate = enrollmentDate;
		this.customerType = customerType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}