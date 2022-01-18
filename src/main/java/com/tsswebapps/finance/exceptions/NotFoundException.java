package com.tsswebapps.finance.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
