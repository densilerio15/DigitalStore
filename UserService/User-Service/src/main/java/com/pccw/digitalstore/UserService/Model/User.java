package com.pccw.digitalstore.UserService.Model;

public class User{
	private String qrCodeId;
	private String username;
	private String facialRecognitionId;
	private String password;
	
	public User() {
		username = "";
		facialRecognitionId = "";
		password = "";
		qrCodeId = "";
	}
	public User(String  username, String  facialRecognitionId,
			String password, String qrCodeId) {
		this.username = username;
		this.facialRecognitionId = facialRecognitionId;
		this.password =  password ; 
		this.qrCodeId = qrCodeId;
	}
	
	public void setUserName(String userName) {
		this.username =  userName ; 
	}
	
	public void setFacialRecognitionId(String facialrecognitionId) {
		this.facialRecognitionId =  	facialrecognitionId ; 
	}
	
	public void setPassword(String password) {
		this.password =  password ; 
	}
	
	public void setQrCodeId(String qrCodeId) {
		this.qrCodeId =  qrCodeId ; 
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getFacialRecognitionId() {
		return this.facialRecognitionId;
	}
	public String getPassord() {
		return this.password;
	}
	
	public String getQrCodeId() {
		return this.qrCodeId;
	}
	
	
}
