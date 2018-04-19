package com.pccw.digitalstore.QRCodeService.Services;

import java.util.Map;

public  interface QrCodeService{
	public Map<String,  String> getQrCode(String deviceId, String qrCodeNo);	 
}