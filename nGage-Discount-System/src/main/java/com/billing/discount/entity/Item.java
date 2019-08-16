package com.billing.discount.entity;

import com.billing.discount.constant.ItemCategory;

/**
 * 
 * @author Rahul
 *
 */
public class Item {

	private String itemName;

	private int quantity;

	private double itemCost;

	private ItemCategory category;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double totalCost) {
		this.itemCost = totalCost;
	}

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

}