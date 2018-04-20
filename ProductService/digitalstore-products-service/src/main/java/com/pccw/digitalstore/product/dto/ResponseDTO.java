package com.pccw.digitalstore.product.dto;

import io.swagger.annotations.ApiModelProperty;

public class ResponseDTO<T> {
	
	@ApiModelProperty(notes = "The data")
	private T data;
	private String message;
	
	public ResponseDTO() {
		super();
	}
	
	public ResponseDTO(T object) {
		this.data = object;
	}	
	
	public T getObject() {
		return data;
	}
	public void setObject(T object) {
		this.data = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [data=" + data + ", message=" + message + "]";
	}

}
