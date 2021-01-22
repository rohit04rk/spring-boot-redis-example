package com.example.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map<String, Object>> customExceptionHandler(CustomException e) {

		Map<String, Object> response = new HashMap<>();
		response.put("message", e.getMessage());
		response.put("code", e.getErrorCode());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}