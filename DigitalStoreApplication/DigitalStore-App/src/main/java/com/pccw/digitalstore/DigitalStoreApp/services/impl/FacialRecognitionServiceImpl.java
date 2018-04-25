package com.pccw.digitalstore.DigitalStoreApp.services.impl;

import com.pccw.digitalstore.DigitalStoreApp.services.FacialRecognitionService;

public class FacialRecognitionServiceImpl implements FacialRecognitionService {

	String faceId = "faceId123456";
	boolean isMatched = true;
	
	public String getFaceID(String frsDeviceId) {
		return this.faceId;
	}
	
	public boolean compareFaceId(String frsDeviceId, String visitorId, String faceId) {
		return this.isMatched;
	}
}
