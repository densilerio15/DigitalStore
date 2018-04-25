package com.pccw.digitalstore.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Image not found")
public class ImageNotFoundException extends Exception  {
	
	private static final long serialVersionUID = 1L;

	public ImageNotFoundException(String message){
		super(message);
	}

}
