package com.tsswebapps.finance.exceptions.receita;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.finance.exceptions.NegocioExceptionDto;

@ControllerAdvice(basePackages = "com.tsswebapps.finance.controller")
public class ReceitaNotFoundExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ReceitaNotFoundException.class)
	public NegocioExceptionDto handleReceitaNotFound(ReceitaNotFoundException exception) {
		NegocioExceptionDto negocioException = new NegocioExceptionDto(
				HttpStatus.NOT_FOUND.value(), "Receita não encontrada.", new Date());

		return negocioException;
	}
}
