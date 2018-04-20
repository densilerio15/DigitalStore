package com.pccw.digitalstore.facialRecognitionservice.Service;

import org.springframework.stereotype.Service;

import com.pccw.digitalstore.facialRecognitionservice.Model.FRSCamera;

@Service
public class  FacialRecognitionServiceImpl implements  FacialRecognitionService{

	@Override
	public FRSCamera getFaceId(String deviceId, String key, String token) {
		FRSCamera camera =new FRSCamera(deviceId,key,token);
		//TODO GET request to http://api.<domain>/faceapi/v1/capture using key and token
		//TODO consume returned JSON response containing visitorid and requestId
		camera.setVisitorId("visitorId from FRSAPI");
		camera.setRequestId("requestId  from FRSAPI");
		return camera;
	}

	@Override
	public FRSCamera matchFaceId(String deviceId, String key,
			String token, String visitorId) {
		
		FRSCamera camera =new FRSCamera(deviceId,key,token);
		camera.setVisitorId(visitorId);
		// TODO GET request to http://api.<domain>/faceapi/v1/compare using key,token,and visitorId
		//Mock logic for returned values from camera JSON Response
		float similarity  = 0;
		float threshold = 0;
		if(similarity >=  threshold) {
			camera.setMatchesFaceId(true);
		}else {
			camera.setMatchesFaceId(false);
		}
		return camera;
	}

	
	
}