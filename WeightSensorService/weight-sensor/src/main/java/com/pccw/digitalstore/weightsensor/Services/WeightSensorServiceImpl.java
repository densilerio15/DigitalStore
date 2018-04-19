package com.pccw.digitalstore.weightsensor.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class WeightSensorServiceImpl implements WeightSensorService{

	
	
	@Override
	public Map<String, String> storeWeight(String id, String weight,String deviceId ) {
		Map<String, String> weightSensorData = new HashMap();
		
		weightSensorData.put("UserId",id);
		weightSensorData.put("WeightSensorID",deviceId);
		weightSensorData.put("Weight",weight);
		
		return weightSensorData;
	}

	@Override
	public Map<String, String> getWeight() {
		// TODO Auto-generated method stub
		return null;
	}
	
}