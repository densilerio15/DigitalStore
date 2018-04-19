package com.pccw.digitalstore.UserService.DTO;

public class ResponseDTO{
	public Object data;
	public String message;  
	
	public ResponseDTO(){
		
	}
	
	public ResponseDTO(Object data , String message) {
		this.data = data;
		this.message =  message;
	}
	
}