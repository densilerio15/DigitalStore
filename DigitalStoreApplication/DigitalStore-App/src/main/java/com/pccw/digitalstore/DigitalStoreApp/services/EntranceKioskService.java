package com.pccw.digitalstore.DigitalStoreApp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pccw.digitalstore.DigitalStoreApp.Models.Customer;
import com.pccw.digitalstore.DigitalStoreApp.services.impl.CustomerManagementServiceImpl;
import com.pccw.digitalstore.DigitalStoreApp.services.impl.QRCodeServiceImpl;

@Service
public class EntranceKioskService {
	
	CustomerManagementService cusManService = new CustomerManagementServiceImpl();
	
	QRCodeService qrService = new QRCodeServiceImpl();
	
	@Autowired
	FacialRecognitionService frService;
	
	public String checkFaceCredential(int customerId) {
		String faceId;
		String frsDeviceId = "frsdevice1";
		faceId = frService.getFaceID(frsDeviceId);
		Customer customer = cusManService.getFaceByCustomerId(customerId);
		boolean isUserRegistered = frService.compareFaceId(frsDeviceId, faceId, customer.getFaceId());
		
		if(isUserRegistered) {
			return "customer registerd";
		}
		return "customer unknown";
	}

	public Customer checkHabbitzzCredentials() {
		String qrDeviceId = "qrdevice1";
		String qrCode = qrService.getQrCode(qrDeviceId);
		return cusManService.getUserByQRCode(qrCode);
	}
	
	public String getUserName(int customerId) {
		return cusManService.getCustomerName(customerId); 
	}


}
