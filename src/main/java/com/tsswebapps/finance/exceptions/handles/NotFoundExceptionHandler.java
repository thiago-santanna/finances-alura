package com.tsswebapps.finance.exceptions.handles;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.finance.exceptions.NegocioExceptionDto;
import com.tsswebapps.finance.exceptions.NotFoundException;

@ControllerAdvice(basePackages = "com.tsswebapps.finance.controller")
public class NotFoundExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public NegocioExceptionDto handleReceitaNotFound(NotFoundException exception) {
		NegocioExceptionDto negocioException = new NegocioExceptionDto(
				HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date());

		return negocioException;
	}
}
