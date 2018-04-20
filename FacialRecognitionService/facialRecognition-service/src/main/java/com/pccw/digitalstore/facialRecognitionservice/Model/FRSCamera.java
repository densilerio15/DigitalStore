package com.pccw.digitalstore.facialRecognitionservice.Model;


public class FRSCamera{
	private String key;
	private String token;
	private String visitorId;
	private String requestId;
	private String deviceId;
	private boolean matchesFaceId;
	
	public FRSCamera() {
		
	}
	public FRSCamera(String deviceId) {
		this.deviceId =  deviceId;
	}
	public FRSCamera(String deviceId, String key, String token) {
		this.deviceId  = deviceId;
		this.token = token;
		this.key =  key;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isMatchesFaceId() {
		return matchesFaceId;
	}
	public void setMatchesFaceId(boolean matchesFaceId) {
		this.matchesFaceId = matchesFaceId;
	}
	
	
	
}