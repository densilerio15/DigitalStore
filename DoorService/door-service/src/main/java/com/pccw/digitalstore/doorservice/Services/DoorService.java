package com.pccw.digitalstore.doorservice.Services;

import com.pccw.digitalstore.doorservice.Model.Door;

public interface DoorService{
	public Door openDoor(String  doorId);
	public Door closeDoor(String doorId);
	
	
}