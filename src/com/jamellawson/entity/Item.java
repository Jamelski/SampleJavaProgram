package com.jamellawson.entity;

import java.util.HashSet;
import java.util.Set;

public class Item {
	//Instance Variables
	private String itemName;
	private Set<CustomerItem> customerItem = new HashSet<CustomerItem>();
	
	//Constructors
	public Item(){}
	
	public Item(String itemName){
		this.itemName= itemName;
	}
	public Item(String itemName, Set<CustomerItem> customerItem) {
		super();
		this.itemName = itemName;
		this.customerItem = customerItem;
	}
	
	//Getters and Setters
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Set<CustomerItem> getCustomerItems() {
		return customerItem;
	}
	public void setCustomers(Set<CustomerItem> customerItems) {
		this.customerItem = customerItems;
	}
	
	public void addCustomerItem(CustomerItem customerItem){
		this.customerItem.add(customerItem);
	}
	
	//Override Hashcode and Equals based on Item Name
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	
	
	
}
