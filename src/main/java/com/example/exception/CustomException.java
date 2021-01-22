package com.example.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Integer errorCode;

	public CustomException(String message, Throwable e, Integer errorCode) {
		super(message, e);
		this.errorCode = errorCode;
	}

	public CustomException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
