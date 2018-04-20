package com.pccw.digitalstore.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

public class ResponseDTO<T> {
	
	@ApiModelProperty(notes = "The requested data")
	private T data;
	@JsonInclude(Include.NON_NULL)
	private String message;
	
	public ResponseDTO() {
	}
	
	public ResponseDTO(T data) {
		this.data = data;
	}
	
	public ResponseDTO(T data, String message) {
		this.data = data;
		this.message = message;
	}	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
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
