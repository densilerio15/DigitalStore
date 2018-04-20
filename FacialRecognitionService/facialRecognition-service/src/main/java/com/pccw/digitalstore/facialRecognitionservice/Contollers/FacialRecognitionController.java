package com.pccw.digitalstore.facialRecognitionservice.Contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.facialRecognitionservice.DTO.ResponseDTO;
import com.pccw.digitalstore.facialRecognitionservice.Service.FacialRecognitionService;

@RestController
@RequestMapping("/facialRecognition")
public class FacialRecognitionController{
	
	@Autowired
	FacialRecognitionService facialRecognitionService;
	
	@GetMapping("/{deviceId}/getFaceId")
	public ResponseDTO getFaceID(@PathVariable String deviceId){
		
		//TODO update message for DTO
		String message ="getFaceIdSuccessful";
		return new ResponseDTO(facialRecognitionService.getFaceId(deviceId, 
				"123124124131", "23123123123123"),message);
	
	}
	
	@GetMapping("/{deviceId}/compareFaceId={visitorId}")
	public  ResponseDTO compareFaceId(@PathVariable("deviceId") String deviceId
			,@PathVariable("visitorId")String visitorId) {
		
		//TODO update message for DTO
		String message ="compareFaceIdSuccessful";
		return new ResponseDTO(facialRecognitionService.matchFaceId(deviceId,
				"123124124131", "23123123123123",visitorId),message);
		
	}
	
	
	
	
	
	
	
}
	
