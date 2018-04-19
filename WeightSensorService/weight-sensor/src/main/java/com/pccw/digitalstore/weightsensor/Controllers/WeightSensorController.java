package com.pccw.digitalstore.weightsensor.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.weightsensor.DTO.ResponseDTO;
import com.pccw.digitalstore.weightsensor.Services.WeightSensorService;

@RestController
@RequestMapping("/WeightSensor")
public class  WeightSensorController{
	
	@Autowired
	WeightSensorService weightSensorService;
	
	@GetMapping("/{deviceId}/id={id}/weight={weight}")
	public ResponseDTO storeWeightSensorDetails(@PathVariable("deviceId") String deviceId,
			@PathVariable("id") String  id, @PathVariable("weight") String weight) {
		
		String  message = "Weight Stored Successfully";
		return new ResponseDTO(weightSensorService.storeWeight(id, weight, deviceId), message);
		
	}
	
}