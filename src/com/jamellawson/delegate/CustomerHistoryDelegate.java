package com.jamellawson.delegate;

//Imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jamellawson.entity.*;

public class CustomerHistoryDelegate {
	
	//Reads a file and returns the Items, Customers and CustomerItems
	public List<Set> getCustomerHistory(String filename){
		String line = null;
		ArrayList<Set> currentCustomerHistory = new ArrayList<Set>();
		
		//Sets of Items, Customers, and CustomerItems
		Set<Item> itemSet = new HashSet<Item>();
		Set<Customer> customerSet = new HashSet<Customer>();
		Set<CustomerItem> customerItemSet = new HashSet<CustomerItem>();
		
		
		try{
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null){
				//Temporary Variables
				Customer customer = new Customer();
				Item item = new Item();
				CustomerItem customerItem = new CustomerItem();
				
				String[] tempStringArray = line.split("\\|");
				boolean containsCustomer = false;
				boolean containsItem = false;
				boolean containsCustomerItem = false;
				for(int i=0; i<3; i++){
					switch(i){
						case 0:
							Customer checkCustomer = new Customer(tempStringArray[i]);
							if(customerSet.contains(checkCustomer)){
								for(Customer myCustomer:customerSet){
									if(myCustomer.equals(checkCustomer)){
										customer = myCustomer;
										containsCustomer = true;
									}
								}
							}else{
								customer = checkCustomer;
							}

							System.out.println("Check Customer: " + customer.getName());
							break;
						case 1:
							if(!containsCustomer){
								customer.setName(tempStringArray[i]);
							}
							break;
						case 2:
							Item checkItem = new Item(tempStringArray[i]);
							if (itemSet.contains(checkItem)){
								for(Item myItem:itemSet){
									if(myItem.equals(checkItem)){
										item = myItem;
										containsItem = true;
									}
								}
							}else{
								item = checkItem;
							}
							System.out.println("Check Item: " + item.getItemName());
					}
				}
				
				CustomerItem checkCustomerItem = new CustomerItem(customer, item, 1);
				
				if(customerItemSet.contains(checkCustomerItem)){
					System.out.println("HELLO");
					containsCustomerItem = true;
					for(CustomerItem myCustomerItem:customerItemSet){
						if(myCustomerItem.equals(checkCustomerItem)){
							customerItem = myCustomerItem;
							System.out.println("Check Quantity: " + customerItem.getQuantity());
							customerItem.setQuantity(customerItem.getQuantity() + 1);
							break;
						}
					}
				}else{
					customerItem = checkCustomerItem;
				}
				
				customer.addCustomerItem(customerItem);
				item.addCustomerItem(customerItem);
				
				if(containsCustomer){
					//Remove old customer information
					customerSet.remove(customer);
					//Add updated customer's information
					customerSet.add(customer);
				}else{
					customerSet.add(customer);
				}
				
				if(containsItem){
					//Remove old item information
					itemSet.remove(item);
					//Add update item information
					itemSet.add(item);
				}else{
					itemSet.add(item);
				}
				
				if(containsCustomerItem){
					customerItemSet.remove(customerItem);
					customerItemSet.add(customerItem);
				}else{
					customerItemSet.add(customerItem);
				}
				
			}
			
			currentCustomerHistory.add(customerSet);
			currentCustomerHistory.add(itemSet);
			bufferedReader.close();
			
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentCustomerHistory;
	}
	
	public static void main(String[] args){
		CustomerHistoryDelegate customerHistory = new CustomerHistoryDelegate();
		for(Set o:customerHistory.getCustomerHistory("samplePurchases.txt")){
			for(Object oj:o){
				if(oj instanceof Customer){
					Customer tempCustomer = (Customer) oj;
					HashSet<CustomerItem> ci = (HashSet<CustomerItem>) tempCustomer.getCustomerItems();
					for(CustomerItem myCi:ci){
						System.out.println(myCi.getCustomer().getName());
						System.out.println(myCi.getItem().getItemName());
						System.out.println(myCi.getQuantity());
					}
					//System.out.println(tempCustomer.getName());
				}
				
				if(oj instanceof Item){
					//Item tempItem = (Item) oj;
					//System.out.println(tempItem.getItemName());
				}
			}
		}
		
		
	}
	
	
}
