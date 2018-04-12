package com.pccw.digitalstore.doorservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.doorservice.DTO.ResponseDTO;

import com.pccw.digitalstore.doorservice.Services.DoorService;

@RestController
@RequestMapping("/door")
public class DoorController{
	
	@Autowired
	DoorService doorService;

	@GetMapping("/{doorid}/open")
	public ResponseDTO open(@PathVariable("doorid") String id){
		String serviceStatus = "Up";
		String message = "Mock Door is  open";
		return new ResponseDTO(serviceStatus,doorService.openDoor(id),message); 
	}
	
	@GetMapping("/{doorid}/close")
	public ResponseDTO  close(@PathVariable("doorid") String id){
		String serviceStatus = "Up";
		String message = "Mock Door is close";
		return new ResponseDTO( serviceStatus,doorService.closeDoor(id),message); 
	}
	
	
	
	
	
	
	
}