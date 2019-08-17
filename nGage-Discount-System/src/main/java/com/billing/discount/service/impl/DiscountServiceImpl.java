package com.billing.discount.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.billing.discount.constant.CustomerType;
import com.billing.discount.constant.DiscountConstant;
import com.billing.discount.constant.ItemCategory;
import com.billing.discount.entity.Customer;
import com.billing.discount.entity.Item;
import com.billing.discount.service.DiscountService;

/**
 * 
 * @author Rahul
 *
 */
public class DiscountServiceImpl implements DiscountService {

	@Override
	public double discountApplyOnUserType(Customer customer, List<Item> items) {

		double totalDiscountedAmount = 0;
		double totalAmount = this.getTotalAmountItems(items);
		double discountPercentage = this.getDiscountByCustomerType(customer);

		Double groceriesTotalAmount = getGroceriedItemCost(items);
		totalDiscountedAmount = (totalAmount - groceriesTotalAmount);
		totalDiscountedAmount = ((totalDiscountedAmount * discountPercentage) / 100);

		return totalAmount - totalDiscountedAmount;
		}

	@Override
	public double getDiscountOnTotalAmount(double totalAmount) {
		return Math.floor(totalAmount / 100) * DiscountConstant.DISCOUNT_PER_HUNDRED;
	}

	@Override
	public double getTotalAmountItems(List<Item> items) {
		return items.stream().map(p -> p.getItemCost()).collect(Collectors.summingDouble(Double::doubleValue));
	}

	@Override
	public double getGroceriedItemCost(List<Item> items) {

		return items.stream()
				.filter(item -> item.getCategory() != null && item.getCategory().equals(ItemCategory.GROCERIES))
				.map(p -> p.getItemCost()).collect(Collectors.summingDouble(Double::doubleValue));
	}

	@Override
	public boolean isDiscountOnMembership(Customer customer) {
		LocalDate date = LocalDate.now().minusYears(DiscountConstant.CUSTOMER_MEMBERSHIP_TIME_PERIOD_IN_YRS);
		return customer.getEnrollmentDate().isBefore(date) && (CustomerType.CUSTOMER == customer.getCustomerType());
	}

	@Override
	public double getDiscountByCustomerType(Customer customer) {
		CustomerType customerType = customer.getCustomerType();
		if (customerType == CustomerType.EMPLOYEE || customerType == CustomerType.AFFILIATE
				|| this.isDiscountOnMembership(customer)) {
			return customerType.getDiscountPercentage();
		}
		return 0;
	}

}
