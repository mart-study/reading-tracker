package com.reading.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reading.tracker.dto.ErrorMessage;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({BookNotFoundException.class})
	public ResponseEntity<ErrorMessage> idNotFoundException(RuntimeException exception) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NO_CONTENT.value(), exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
	}
}
