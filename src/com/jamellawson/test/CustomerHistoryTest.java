package com.jamellawson.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jamellawson.entity.Customer;
import com.jamellawson.entity.CustomerItem;
import com.jamellawson.entity.Item;

public class CustomerHistoryTest {

	@Test
	public void test() {
		Customer myCustomer = new Customer("000-838-9883", "JL");
		Item myItem = new Item("car");
		CustomerItem myCustomerItem = new CustomerItem(myCustomer, myItem, 1);
		
		assertNotNull(myCustomerItem.getItem());
		
	}

}
