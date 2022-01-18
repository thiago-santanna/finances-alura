package com.tsswebapps.finance.exceptions.receita;

public class ReceitaBadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReceitaBadRequestException() {
		super();
	}

	public ReceitaBadRequestException(String message) {
		super(message);
	}
}
