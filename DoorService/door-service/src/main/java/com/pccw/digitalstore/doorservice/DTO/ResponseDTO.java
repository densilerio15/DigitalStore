package com.pccw.digitalstore.doorservice.DTO;

import com.pccw.digitalstore.doorservice.Model.Door;

public class ResponseDTO{
	private String serviceState;
	private Door door;  
	private String message;
	public ResponseDTO(){
		this.serviceState = "Active";
		this.door =  new Door();
		this.message =  "Door mock test";
	}
	public ResponseDTO(Door door) {
		this.serviceState = "Active";
		this.door = door;
		this.message =  "Door mock test";
	}
	public ResponseDTO(String serviceState,  Door  door, String message) {
		this.serviceState = serviceState;
		this.door = door;
		this.message =  message;
	}
	public String  getServiceState() {
		return  serviceState;
	}
	public String  getMessage() {
		return  message;
	}
	public void setMessage(String  message) {
		this.message = message;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}
	public void setDoor(Door door) {
		this.door = door;
	}
	public Door getDoor() {
		return this.door;
	}
	
}