package com.pccw.digitalstore.facialRecognitionservice.DTO;

import com.pccw.digitalstore.facialRecognitionservice.Model.FRSCamera;

public class ResponseDTO{
	private FRSCamera frsCamera;
	private String message;
	
	public ResponseDTO() {
	}
	public ResponseDTO(FRSCamera frsCamera,
			String message){
		this.frsCamera = frsCamera;
		this.message = message;
	}
	public FRSCamera getFrsCamera() {
		return frsCamera;
	}
	public void setFrsCamera(FRSCamera frsCamera) {
		this.frsCamera = frsCamera;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}