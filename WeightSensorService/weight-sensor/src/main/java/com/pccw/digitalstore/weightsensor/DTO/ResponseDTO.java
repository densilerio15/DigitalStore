package com.pccw.digitalstore.weightsensor.DTO;

public class ResponseDTO{
	private String serviceState;
	private Object data;
	private String message;
	public ResponseDTO(){
	}
	public ResponseDTO(Object  data , String message) {
		this.data = data;
		this.message =  message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object Data) {
		this.data = data;
	}
	
	public String  getMessage() {
		return  message;
	}
	public void setMessage(String  message) {
		this.message = message;
	}


}

	