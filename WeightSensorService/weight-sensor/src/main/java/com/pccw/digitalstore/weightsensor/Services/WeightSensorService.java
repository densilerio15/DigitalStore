package com.pccw.digitalstore.weightsensor.Services;

import java.util.Map;

public interface WeightSensorService{
	/*
	 * @Param 
	 * String id =  bind weight with a product, user  etc. 
	 * String weight = actual weight  from weight sensor
	 * String deviceId = Id  of weight sensor
	 * */
	public Map<String, String> storeWeight(String id, String weight,String deviceId);
	public Map<String, String> getWeight();
}