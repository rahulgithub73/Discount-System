package com.billing.discount.service;

import java.util.List;

import com.billing.discount.entity.Customer;
import com.billing.discount.entity.Item;

/**
 * 
 * @author Rahul
 *
 */
public interface DiscountService {

	/**
	 * This method used to apply discount based on user type
	 * 
	 * @param customer : Object of customer, this contains user information
	 * @param items    : List of billing items
	 * @return value of double
	 */
	double discountApplyOnUserType(Customer customer, List<Item> items);

	/**
	 * This method used to apply discount on final amount
	 * 
	 * @param totalAmountAfterDiscount : Total amount after user type discount
	 * @return value of double
	 */
	double getDiscountOnTotalAmount(double totalAmountAfterDiscount);

	/**
	 * This method used to calculate sum of all billing items
	 * 
	 * @param items : List of billing items
	 * @return value of double
	 */

	double getTotalAmountItems(List<Item> items);

	/**
	 * This method used to calculate sum of Groceries billing items
	 * 
	 * @param items : List of billing items
	 * @return value of double
	 */

	double getGroceriedItemCost(List<Item> items);

	/**
	 * This method used to validate Membership of customer
	 * 
	 * @param customer : Object of customer, this contains user information
	 * @return value of boolean (True/False)
	 */

	boolean isDiscountOnMembership(Customer customer);

	/**
	 * This method used to get discount % by Customer type
	 * 
	 * @param customer: Object of customer, this contains user information
	 * @return value of double
	 */

	double getDiscountByCustomerType(Customer customer);
}
