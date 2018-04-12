package com.pccw.digitalstore.doorservice.Services;

import org.springframework.stereotype.Service;

import com.pccw.digitalstore.doorservice.Model.Door;

@Service
public class DoorServiceImpl implements DoorService{
	private Door door;	
	
	@Override
	public Door openDoor(String doorId) {
		door =  new Door();
		door.setDoorName(doorId);
		door.setDoorState("1");
		return  door;
	}

	@Override
	public Door closeDoor(String doorId) {
		door =  new Door();
		door.setDoorName(doorId);
		door.setDoorState("0");
		return  door;
}
	
	public void manualOpenDoor(Door door) {
		door.setDoorState("1");
	}
	public void manualCloseDoor(Door door) {
		door.setDoorState("0");
	}

	
	
}