package com.pccw.digitalstore.DigitalStoreApp.services.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pccw.digitalstore.DigitalStoreApp.Models.Customer;
import com.pccw.digitalstore.DigitalStoreApp.services.CustomerManagementService;

public class CustomerManagementServiceImpl implements CustomerManagementService{

	private static Map<Integer, Customer> customers;

	static {
		customers = new HashMap<Integer, Customer>() {
			{
				put(1, new Customer("Calvin", "qr1", "f1"));
				put(2, new Customer("King", "qr2","f2"));
				put(3, new Customer("Ethan", "qr3", "f3"));
			}
		};
	}

	
	public Customer getUserByQRCode(String qrCodeId) {
	/*    for (Entry<Integer, Customer> entry : customers.entrySet()) {
	    	customer = entry.getValue();
	    	 if (customer.getQrCode().equals(qrCodeId)) {
	         }
	    }*/
	    
	    return (Customer) customers.entrySet()
	              .stream()
	              .filter(customer -> customer.getValue().getQrCode().equals(qrCodeId))
	              .map(customer ->customer.getValue());
	}

	@Override
	public Collection<Customer> getCustomers(){
		return this.customers.values();
	}

	@Override
	public String getCustomerName(int customerId) {
		return customers.get(customerId).getCustomerName();
	}

	@Override
	public Customer getFaceByCustomerId(int customerId) {
		return customers.get(customerId);
	}

}
