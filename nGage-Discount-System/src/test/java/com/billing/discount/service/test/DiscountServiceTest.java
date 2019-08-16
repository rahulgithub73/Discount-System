package com.billing.discount.service.test;

import static org.junit.Assert.assertEquals;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.billing.discount.constant.CustomerType;
import com.billing.discount.constant.ItemCategory;
import com.billing.discount.entity.Customer;
import com.billing.discount.entity.Item;
import com.billing.discount.service.impl.DiscountServiceImpl;

/*
 * The following discounts apply using this application
 * 
 * 1. If the user is an employee of the store, he gets a 30% discount 
 * 2. If the user is an affiliate of the store, he gets a 10% discount 
 * 3. If the user has been a customer for over 2 years, he gets a 5% discount. 
 * 4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). 
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.  
 * 
 * 
 * find the all test cases and final bill amount after discount
 * 
 * 
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServiceTest {

	@Mock
	List<Item> items;

	@InjectMocks
	DiscountServiceImpl discountService;

	@Bean
	public Clock clock() {
		return Clock.systemDefaultZone();
	}

	@Before
	public void setUp() {
		discountService = new DiscountServiceImpl();
		this.localDateMethod();

	}

	@Before
	public void loadItemList() {

		items = new ArrayList<Item>();
		Item item = new Item();

		item = new Item();
		item.setItemName("Bread");
		item.setItemCost(200.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.GROCERIES);
		items.add(item);

		item = new Item();
		item.setItemName("Milk");
		item.setItemCost(100.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.GROCERIES);
		items.add(item);

		item = new Item();
		item.setItemName("oven");
		item.setItemCost(200.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.ELECTRONICS);
		items.add(item);

		item = new Item();
		item.setItemName("phone");
		item.setItemCost(100.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.ELECTRONICS);
		items.add(item);

		item = new Item();
		item.setItemName("bat-and-ball");
		item.setItemCost(200.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.SPORTS);
		items.add(item);

		item = new Item();
		item.setItemName("Baseball");
		item.setItemCost(100.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.SPORTS);
		items.add(item);

		item = new Item();
		item.setItemName("other new item");
		item.setItemCost(100.00);
		item.setQuantity(1);
		item.setCategory(ItemCategory.OTHER);
		items.add(item);

	}

	public Customer getEmployeeCustomer() {
		return new Customer("1", "rahul", "rahul@gmail.com", LocalDate.now().minusYears(3), CustomerType.EMPLOYEE);
	}

	public Customer getAffiliateCustomer() {
		return new Customer("2", "rohan", "rohan@gmail.com", LocalDate.now().minusYears(3), CustomerType.AFFILIATE);
	}

	public Customer getCustomerMoreThanTwoYearEnrollment() {
		return new Customer("3", "ram", "ram@gmail.com", LocalDate.now().minusYears(3), CustomerType.CUSTOMER);
	}

	public Customer getCustomerLessThanTwoYearEnrollment() {
		return new Customer("4", "rohit", "rohit@gmail.com", LocalDate.now().minusYears(1), CustomerType.CUSTOMER);
	}

	// EMPLOYEE type customer get 30% discount
	@Test
	public void discountForEmployeeCustomer() {
		assertEquals(790.00, discountService.discountApplyOnUserType(this.getEmployeeCustomer(), items), 0);
	}

	// AFFILIATE type customer get 10% discount
	@Test
	public void discountforAffiliateCustomer() {
		assertEquals(930.00, discountService.discountApplyOnUserType(this.getAffiliateCustomer(), items), 0);
	}

	// CUSTOMER type customer get 5% discount when more than two year enrollment
	@Test
	public void discountForEligibleCustomer() {
		assertEquals(965.00,
				discountService.discountApplyOnUserType(this.getCustomerMoreThanTwoYearEnrollment(), items), 0);
	}

	// CUSTOMER type customer get 0% discount when less than two year enrollment
	@Test
	public void discountForNonEligibleCustomer() {
		assertEquals(1000.00,
				discountService.discountApplyOnUserType(this.getCustomerLessThanTwoYearEnrollment(), items), 0);
	}

	// CUSTOMER type customer get 5% discount when more than two year enrollment
	// For every $100 on the bill, there would be a $ 5 discount
	@Test
	public void discountForFinalAmount() {
		double totalAmount = discountService.discountApplyOnUserType(this.getCustomerMoreThanTwoYearEnrollment(),
				items);
		assertEquals(920.00, totalAmount - discountService.getDiscountOnTotalAmount(totalAmount), 0);
	}

	// sum of all item amount
	@Test
	public void getTotalAmountItems() {
		assertEquals(1000.00, discountService.getTotalAmountItems(items), 0);
	}

	// discount applicable on Membership
	@Test
	public void isDiscountOnMembershipTrue() {
		assertEquals(true, discountService.isDiscountOnMembership(this.getCustomerMoreThanTwoYearEnrollment()));
	}

	// discount not applicable on Membership
	@Test
	public void isDiscountOnMembershipFalse() {
		assertEquals(false, discountService.isDiscountOnMembership(this.getCustomerLessThanTwoYearEnrollment()));
	}

	// Discount % By Customer Type
	@Test
	public void getDiscountByCustomerType() {
		assertEquals(30, discountService.getDiscountByCustomerType(this.getEmployeeCustomer()), 0);
	}

	// sum of GROCERIES Item amount
	@Test
	public void getGroceriedItemCost() {
		assertEquals(300.00, discountService.getGroceriedItemCost(items), 0);
	}

	// validate customer type
	@Test
	public void testCustomerTypesValues() {
		assertEquals(3, CustomerType.values().length);
	}

	// validate item category GROCERIES
	@Test
	public void testItemCategory() {
		assertEquals(ItemCategory.GROCERIES, ItemCategory.valueOf("GROCERIES"));
	}

	// validate sum of item category
	public void testItemCategoryValues() {
		assertEquals(4, ItemCategory.values().length);
	}

	@Test
	public void dataLoads() {
		System.out.println("---------- Item list and customer data Loaded ----------");

	}

	private LocalDate localDateMethod() {
		return LocalDate.now(clock());
	}

}
