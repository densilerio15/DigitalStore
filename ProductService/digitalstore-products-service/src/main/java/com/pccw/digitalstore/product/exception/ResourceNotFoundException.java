package com.pccw.digitalstore.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Resource Not Found")
public class ResourceNotFoundException extends Exception {

		private static final long serialVersionUID = -3332292346834265371L;

		public ResourceNotFoundException(String key, Object id){
			super("ResourceNotFoundException with " + key + " = " + id);
		}
		
		public ResourceNotFoundException(Long id){
			super("ResourceNotFoundException with  id= " + id);
		}
	}
