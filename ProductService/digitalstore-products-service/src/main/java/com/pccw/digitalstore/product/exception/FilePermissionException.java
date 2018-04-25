package com.pccw.digitalstore.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="File access permission error")
public class FilePermissionException extends RuntimeException  {
	private static final long serialVersionUID = 5498113928135885025L;

	public FilePermissionException(String message){
		super("File permission error");
	}

}
