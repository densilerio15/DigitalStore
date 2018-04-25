package com.pccw.digitalstore.DigitalStoreApp.Models;

public class Customer {

	private String qrCode;

	public Customer(String customerName, String qrCode, String faceId) {
		super();
		this.customerName = customerName;
		this.qrCode = qrCode;
		this.faceId = faceId;
	}

	private String customerName;

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	private String faceId;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

}
