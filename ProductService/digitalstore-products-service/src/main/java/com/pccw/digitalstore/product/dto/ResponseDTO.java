package com.pccw.digitalstore.product.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO<T> {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> serviceStatus = new HashMap<>();
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String transactionStatus;
	@JsonProperty("data")
	private T object;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> message = new HashMap<>();
	
	public ResponseDTO() {
		super();
	}
	
	public ResponseDTO(Map<String, String> serviceStatus, String transactionStatus, T object, Map<String, String> message) {
		this.serviceStatus = serviceStatus;
		this.transactionStatus = transactionStatus;
		this.object = object;
		this.message = message;
	}
	
	public ResponseDTO(String transactionStatus, T object) {
		this.transactionStatus = transactionStatus;
		this.object = object;
	}
	
	public ResponseDTO(T object) {
		this.object = object;
	}	
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
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public Map<String, String> getMessage() {
		return message;
	}
	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
	
	public void addServiceStatus(String key, String value) {
		this.serviceStatus.put(key, value);
	}
	
	public void addMessage(String key, String value) {
		this.serviceStatus.put(key, value);
	}
	
	@Override
	public String toString() {
		return "ResponseDTO [serviceStatus=" + serviceStatus + ", transactionStatus=" + transactionStatus + ", object="
				+ object + ", message=" + message + "]";
	}

}
