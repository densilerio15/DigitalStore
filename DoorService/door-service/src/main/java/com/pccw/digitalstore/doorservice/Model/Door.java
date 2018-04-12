package com.pccw.digitalstore.doorservice.Model;

public class  Door{
	private String doorName;
	private String doorState;
	
	public Door() {
		this.doorName ="";
		this.doorState ="";
	}
	public String getDoorName() {
		return doorName;
	}
	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}

	
	public String  getDoorState() {
		switch(doorState){
		case "0":
			this.doorState = "CLOSE";
			break;
		case "1":
			this.doorState ="OPEN";
			break;
		default:
			this.doorState ="Door state  unknown";
			break;
		}
		return  doorState;
	}
	
	public void setDoorState(String doorState) {
		this.doorState = doorState;
	}
}