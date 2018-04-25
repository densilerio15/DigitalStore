package com.pccw.digitalstore.product.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.pccw.digitalstore.product.dto.ErrorDetailsDTO;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ExceptionHandlerExceptionResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalResponseEntityExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorDetailsDTO> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(NOT_FOUND, ex.getMessage(), ex);
		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ImageNotFoundException.class)
	public final ResponseEntity<ErrorDetailsDTO> handleImageNotFoundException(ImageNotFoundException ex,
			WebRequest request) {
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(NOT_FOUND, ex.getMessage(), ex);
		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FilePermissionException.class)
	public final ResponseEntity<ErrorDetailsDTO> handleFilePermissionException(FilePermissionException ex,
			WebRequest request) {
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(NOT_FOUND, ex.getMessage(), ex);
		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetailsDTO> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(INTERNAL_SERVER_ERROR, "Server Error", ex);
		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
