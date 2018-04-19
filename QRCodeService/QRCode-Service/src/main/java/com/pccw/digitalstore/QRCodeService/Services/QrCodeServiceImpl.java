package com.pccw.digitalstore.QRCodeService.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class QrCodeServiceImpl implements QrCodeService{

	@Override
	public Map<String, String> getQrCode(String deviceId, String qrCodeNo) {
		Map<String,String> qrCode = new HashMap();
		qrCode.put("DeviceID", deviceId);
		qrCode.put("QRCodeValue.", qrCodeNo);
		return qrCode;
	}
	
}