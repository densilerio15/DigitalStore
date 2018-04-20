package com.pccw.digitalstore.category.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.pccw.digitalstore.category.dto.ErrorDetailsDTO;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ExceptionHandlerExceptionResolver {
	
	  @ExceptionHandler(ResourceNotFoundException.class)
	  public final ResponseEntity<ErrorDetailsDTO> handleSampleException(ResourceNotFoundException ex, WebRequest request) {
		  ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(NOT_FOUND,"Resouce requested was not found", ex);
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(Exception.class)
	  public final ResponseEntity<ErrorDetailsDTO> handleAllExceptions(Exception ex, WebRequest request) {
		  ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(INTERNAL_SERVER_ERROR, "Server Error", ex);
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
