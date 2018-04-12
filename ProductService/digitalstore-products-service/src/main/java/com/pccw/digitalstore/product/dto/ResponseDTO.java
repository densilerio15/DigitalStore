package com.pccw.digitalstore.product.dto;

import java.util.Map;

public class ResponseDTO {
	
	public ResponseDTO() {
		super();
	}
	
	public ResponseDTO(Map<String, String> serviceStatus, String transactionStatus, Object object, Map<String, String> message) {
		this.serviceStatus = serviceStatus;
		this.transactionStatus = transactionStatus;
		this.object = object;
		this.message = message;
	}
	
	Map<String, String> serviceStatus;
	String transactionStatus;
	Object object;
	Map<String, String> message;
	
	public Map<String, String> getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(Map<String, String> serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Map<String, String> getMessage() {
		return message;
	}
	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResponseDTO [serviceStatus=" + serviceStatus + ", transactionStatus=" + transactionStatus + ", object="
				+ object + ", message=" + message + "]";
	}

}
