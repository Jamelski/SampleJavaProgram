package com.jamellawson.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	//Instance variables
	private String ssn;
	private String name;
	private Set<CustomerItem> customerItems = new HashSet<CustomerItem>();
	

	//Empty Constructor
	public Customer(){}
	
	public Customer(String ssn){
		this.ssn = ssn;
	}
	public Customer(String ssn, String name) {
		super();
		this.ssn = ssn;
		this.name = name;
	}
	
	//Getters and Setters
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<CustomerItem> getCustomerItems() {
		return customerItems;
	}

	public void setCustomerItems(Set<CustomerItem> customerItems) {
		this.customerItems = customerItems;
	}
	
	public void addCustomerItem(CustomerItem customerItem){
		this.customerItems.add(customerItem);
	}
	
	//hashcode and equals overrides check SSN
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		Customer other = (Customer) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}
	
}
