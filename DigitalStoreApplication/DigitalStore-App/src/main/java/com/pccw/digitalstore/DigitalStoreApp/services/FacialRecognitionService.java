package com.pccw.digitalstore.DigitalStoreApp.services;

public interface FacialRecognitionService {

	public String getFaceID(String frsDeviceId);
	
	public boolean compareFaceId(String frsDeviceId, String visitorId, String string);
}
