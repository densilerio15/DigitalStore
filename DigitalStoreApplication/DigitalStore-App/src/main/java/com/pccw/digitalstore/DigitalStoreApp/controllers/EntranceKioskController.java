package com.pccw.digitalstore.DigitalStoreApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.DigitalStoreApp.Models.Customer;
import com.pccw.digitalstore.DigitalStoreApp.services.CustomerManagementService;
import com.pccw.digitalstore.DigitalStoreApp.services.EntranceKioskService;
import com.pccw.digitalstore.DigitalStoreApp.services.FacialRecognitionService;
import com.pccw.digitalstore.DigitalStoreApp.services.QRCodeService;
import com.pccw.digitalstore.DigitalStoreApp.services.impl.QRCodeServiceImpl;

@RestController
@RequestMapping("/entranceKiosk")
public class EntranceKioskController {
	
	@Autowired
	EntranceKioskService service;
	
	String faceId;
	
	@RequestMapping(value = "getUsername/{id}", method = RequestMethod.GET)
	public String getUsername(@PathVariable("id") int id)
	{
		return service.getUserName(id);
	}
	
	/**
	 * reads qr code provided by user and checks from cusManService if QR code matches with user
	 * @return userId from cusManService (habbitzz Customer database)
	 */
	@GetMapping("/checkHabbitzzCredentials")
	public Customer checkHabbitzzCredentials() {
		return service.checkHabbitzzCredentials();
	}
	
	/**
	 * scans user face and compares it to the faceIds in cusManService
	 * @return 
	 */
	@GetMapping("/checkFaceCredential")
	public String checkFaceCredential(int customerId){
		return service.checkFaceCredential(customerId);
	}

	
}
