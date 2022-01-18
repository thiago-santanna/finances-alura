package com.tsswebapps.finance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends NegocioException {

	public EntidadeNaoEncontradaException(String menssagem) {
		super(menssagem);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
