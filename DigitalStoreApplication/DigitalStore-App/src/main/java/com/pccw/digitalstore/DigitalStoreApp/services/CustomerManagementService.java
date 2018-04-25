package com.pccw.digitalstore.DigitalStoreApp.services;

import java.util.Collection;

import com.pccw.digitalstore.DigitalStoreApp.Models.Customer;

public interface CustomerManagementService {

	Collection<Customer> getCustomers();

	Customer getUserByQRCode(String qrCodeId);

	String getCustomerName(int customerId);

	Customer getFaceByCustomerId(int customerId);

}
