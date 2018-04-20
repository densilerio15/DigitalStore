package com.pccw.digitalstore.facialRecognitionservice.Service;


import com.pccw.digitalstore.facialRecognitionservice.Model.FRSCamera;

public interface FacialRecognitionService{
	public FRSCamera getFaceId(String deviceId,String key,String token);
	public FRSCamera matchFaceId(String deviceId,String key,String token,String visitorId);
	
}
