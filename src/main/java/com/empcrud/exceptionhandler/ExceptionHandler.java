package com.empcrud.exceptionhandler;

public class ExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public ExceptionHandler(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
