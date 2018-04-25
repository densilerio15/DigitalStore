package com.pccw.digitalstore.DigitalStoreApp.services.impl;

import com.pccw.digitalstore.DigitalStoreApp.services.QRCodeService;

public class QRCodeServiceImpl implements QRCodeService{

	String qrCode="qr1";
	String qrDeviceId;
	
	public String getQrCode(String qrDeviceId) {
		this.qrDeviceId = qrDeviceId;
		return this.qrCode;
	}

}
