package com.jamellawson.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.jamellawson.entity.Customer;
import com.jamellawson.entity.CustomerItem;
import com.jamellawson.entity.Item;
public class CustomerItemEqualityTest {

	@Test
	public void test() {
		Customer myCustomer = new Customer("000-000-0000","JL");
		Item myItem = new Item("book");
		CustomerItem myCi = new CustomerItem(myCustomer, myItem, 1);
		CustomerItem identicalCi = new CustomerItem(myCustomer, myItem, 1);
		
		myCustomer.addCustomerItem(myCi);
		myItem.addCustomerItem(myCi);
		
		assertNotNull(myCustomer.getCustomerItems());
		assertNotNull(myItem.getCustomerItems());
		
		for(CustomerItem ci:myCustomer.getCustomerItems()){
			assertNotNull(ci.getId());
			System.out.println(ci.getId().getCustomerName());
		}
		Set<CustomerItem> testCi = myCustomer.getCustomerItems();
		Set<CustomerItem> testItemCi = myItem.getCustomerItems();
		for(CustomerItem tempCi:testCi){
			assertEquals(tempCi, myCi);
		}
		
		assertTrue(testItemCi.contains(identicalCi));
		assertTrue(testCi.contains(myCi));
		assertTrue(testItemCi.contains(myCi));
		
	}

}
