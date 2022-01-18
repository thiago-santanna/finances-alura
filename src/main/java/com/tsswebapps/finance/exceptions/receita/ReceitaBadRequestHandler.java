package com.tsswebapps.finance.exceptions.receita;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.finance.exceptions.NegocioExceptionDto;

@ControllerAdvice("com.tsswebapps.finance.controller")
public class ReceitaBadRequestHandler {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ReceitaBadRequestException.class)
	public NegocioExceptionDto handleReceitaBadRequest(ReceitaBadRequestException exception) {
		NegocioExceptionDto negocioExceptionDto = new NegocioExceptionDto(
				HttpStatus.BAD_REQUEST.value(),	exception.getMessage(),	new Date());
		return negocioExceptionDto;				
	}
}
