package com.tsswebapps.finance.exceptions.handles;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.finance.exceptions.NegocioExceptionDto;
import com.tsswebapps.finance.exceptions.BadRequestException;

@ControllerAdvice("com.tsswebapps.finance.controller")
public class BadRequestHandler {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public NegocioExceptionDto handleReceitaBadRequest(BadRequestException exception) {
		NegocioExceptionDto negocioExceptionDto = new NegocioExceptionDto(
				HttpStatus.BAD_REQUEST.value(),	exception.getMessage(),	new Date());
		return negocioExceptionDto;				
	}
}
