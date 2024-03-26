package com.example.demo.exception;



import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class HotelExceptionHandler extends ResponseEntityExceptionHandler{
	// Add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<HotelErrorResponse> handleException(ResourceNotFoundException exc) {

			// create a StudentErrorResponse
			HotelErrorResponse error = new HotelErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity

			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		// add another exception handler - to catch any type of exception (catch all)
		@ExceptionHandler
		public ResponseEntity<HotelErrorResponse> handleException(Exception exc) {
			// create a StudentErrorResponse
			HotelErrorResponse error = new HotelErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		
      @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	// TODO Auto-generated method stub
    	  Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) ->{
				
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    	//return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
