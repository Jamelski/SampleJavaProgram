package com.jamellawson.entity;

public class CustomerItem {
	
	public static class CompositeKey{
		
		//Inner Class instance variables
		private static String customerName;
		private static String itemName;
		
		//Inner Class Constructors
		public CompositeKey(){}
		
		public CompositeKey(String customerName, String itemName) {
			super();
			this.customerName = customerName;
			this.itemName = itemName;
		}
		
		//Inner Class getters and setters
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		
		//Inner Class Override Hashcode and Equals on Item Name and Customer Name
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((customerName == null) ? 0 : customerName.hashCode());
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
			CompositeKey other = (CompositeKey) obj;
			if (customerName == null) {
				if (other.customerName != null)
					return false;
			} else if (!customerName.equals(other.customerName))
				return false;
			if (itemName == null) {
				if (other.itemName != null)
					return false;
			} else if (!itemName.equals(other.itemName))
				return false;
			return true;
		}
		
		
		
		
	}
	
	//Instance Variables
	private CompositeKey id = new CompositeKey();
	private Customer customer;
	private Item item;
	private int quantity;
	
	//Constructors
	public CustomerItem(){}
	
	public CustomerItem(Customer customer, Item item,
			int quantity) {
		super();
		
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
		
		this.id.customerName= customer.getName();
		this.id.itemName = item.getItemName();
		
		item.getCustomerItems().add(this);
		customer.getCustomerItems().add(this);
	}

	//Getters and Setters
	public CompositeKey getId() {
		return id;
	}
	
	
	public void setId(Customer customer, Item item) {
		this.id.customerName = customer.getName();
		this.id.itemName = item.getItemName();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
	public void addQuantityByOne(){
		this.quantity++;
	}
	
	//Hashcode and Equals for id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CustomerItem other = (CustomerItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
